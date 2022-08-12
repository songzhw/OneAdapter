# OneAdapter
the simpler version of RecyclerView.Adapter in Android

## import
```groovy
implementation 'ca.six.oneadapter:oneadapter:1.0.1'
```

## usage
```kotlin
        val data = (1..20).map { "ReccylerView Item $it" }
        rvSimple.layoutManager = LinearLayoutManager(this)
        val adapter = object : OneAdapter<String>(R.layout.item_rv_one, data) {
            override fun apply(vh: RvViewHolder, value: String, position: Int) {
                vh.setText(R.id.tv_rv_item, value)
            }
        }
        rvSimple.setAdapter(adapter)
```


# Multiple ItemType Adapter
[Demo](https://github.com/songzhw/OneAdapter/blob/master/app/src/main/java/ca/six/oneadapter/demo/MultiAdapterDemo.kt)

# Builder Adapter
[Demo](https://github.com/songzhw/OneAdapter/tree/master/app/src/main/java/ca/six/oneadapter/demo/builder)

## difference between MultiAdapter and BuilderAdapter
* The usage of MultiAdapter is more like RecyclerView. It still using render() to render each item.
* The usage of BuilderAdapter is more like ScrollView. It can `add(item)` to to add one child to it.MultiAdapter
