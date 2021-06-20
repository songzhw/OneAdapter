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
