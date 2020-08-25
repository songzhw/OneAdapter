package ca.six.oneadapter.lib

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class OneDiffAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>, val layoutResId: Int) :
    RecyclerView.Adapter<RvViewHolder>() {
    private val diff = AsyncListDiffer(this, diffCallback)

    override fun getItemCount(): Int = diff.currentList.size

    // 只在初创时调用过几次. 后面有复用item了, 这个就不会被调用了.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder.createViewHolder(parent, layoutResId)
    }

    // 每次滑动到可见都会被调用, 没有复用不复用的概念. 每个position可见了都会调用这个方法
    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        // println("szw onBindViewHolder( "+position+" )");
        val item = diff.currentList.get(position)
        apply(holder, item, position)
    }

    protected abstract fun apply(vh: RvViewHolder, value: T, position: Int)


    fun refresh(newData: List<T>) {
        diff.submitList(newData)
    }

}
/*
在不同的type 的时候 如果该 type 所对应的 viewHolder 还没被初始化的时候，会重新调用 onCreateViewHolder 的， 而其他的还是会只调用 onBindViewHolder。
即: onCreateViewHolder(ViewGroup parent, int viewType)的参数里没有position, 只有viewType

上下滑动时, onBindViewHolder(vh, position)会被反复调用. 这个有点像ListView.getAdapter()中的getView()

 */