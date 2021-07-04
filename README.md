# MultiTypeCompose
简化Jetpack Compose 长列表构建 
## 效果预览


## 如何使用

- 实现接口：
```kotlin
class CoverComposable : IComposableService<Cover> {

    override val content: @Composable (item: Cover) -> Unit = { item ->
        HomeFeedHeader(item.tag)
        CoverSection(item = item)
    }
}
```

### 手动注册：
```kotlin
registerComposableService(Cover::class, CoverComposable())
```

- 在Lazy*里使用
```kotlin
    LazyColumn{
        items(viewModel.produceItems()) {
            ComposableItem(item = it)
        }
    }
```


### 自动注册
这里还提供一直服务发现的使用方式，省去手动注册。
- 使用AutoService,添加依赖
```kotlin
  implementation 'com.google.auto.service:auto-service:1.0-rc7'
  annotationProcessor 'com.google.auto.service:auto-service:1.0-rc7'
```

- 注解修饰实现
```kotlin
@AutoService(IComposableService::class)
class CoverComposable : IComposableService<Cover> {

    override val content: @Composable (item: Cover) -> Unit = { item ->
        HomeFeedHeader(item.tag)
        CoverSection(item = item)
    }
    override val type: String
        get() = Cover::class.java.name
}
```

- 收集服务并注册
```kotlin
 ComposableServiceManager.collectServices()
```

- 使用
```kotlin
 LazyColumn{
        items(viewModel.produceItems()) {
            ComposableItem(item = it)
        }
    }
```

