package ge.academics.university.projectbtu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.academics.university.projectbtu.R
import ge.academics.university.projectbtu.databinding.RecyclerCartItemBinding

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private var quantity: Int = 1
    private val pricePerUnit: Double = 120.0
    var onQuantityChanged: ((Int, Double) -> Unit)? = null
    var onDeleteItem: (() -> Unit)? = null

    fun updateQuantity(newQuantity: Int) {
        quantity = newQuantity
        notifyDataSetChanged()
    }

    fun getQuantity(): Int = quantity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = RecyclerCartItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 1

    inner class CartViewHolder(
        private val binding: RecyclerCartItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.apply {
                ivProduct.setImageResource(R.drawable.oil_1)
                tvProductName.text = "Oil"
                tvProductDescription.text = "This product is very important and most seller"

                tvQuantity.text = quantity.toString()
                val itemTotal = pricePerUnit * quantity
                tvPrice.text = "${itemTotal.toInt()}\$"

                btnPlus.setOnClickListener {
                    quantity++
                    tvQuantity.text = quantity.toString()
                    val newTotal = pricePerUnit * quantity
                    tvPrice.text = "${newTotal.toInt()}\$"
                    onQuantityChanged?.invoke(quantity, newTotal)
                }

                btnMinus.setOnClickListener {
                    if (quantity > 1) {
                        quantity--
                        tvQuantity.text = quantity.toString()
                        val newTotal = pricePerUnit * quantity
                        tvPrice.text = "$${newTotal.toInt()}\$"
                        onQuantityChanged?.invoke(quantity, newTotal)
                    }
                }

                btnDelete.setOnClickListener {
                    onDeleteItem?.invoke()
                }
            }
        }
    }
}