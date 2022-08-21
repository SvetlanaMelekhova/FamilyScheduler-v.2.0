package com.svetlana.dev.familyschedule_v2_0.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

open class BaseBindingFragment<V : ViewBinding>(
    private val binder: (LayoutInflater, ViewGroup?, Boolean) -> V
) : BaseFragment(0) {

    private var contentBinding: V? = null
    //protected lateinit var prefsUtil: PrefsUtil

    protected val binding: V?
        get() = contentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contentBinding = binder.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //prefsUtil = PrefsUtil(this.requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        contentBinding = null
    }
}

open class BaseFragment(
    @Deprecated(message = "Перейти на BaseBindingFragment")
    @LayoutRes private val resId: Int,
) : Fragment(){

    protected fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    protected fun showSnackBar(view: View, message: String, backgroundColor: Int, textColor: Int){
        val snackBarView =
            Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        val view = snackBarView.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.width = FrameLayout.LayoutParams.MATCH_PARENT
        // params.gravity = Gravity.BOTTOM
        view.layoutParams = params
        //view.background = ContextCompat.getDrawable(requireContext(),R.drawable.round_green_rectangle) // for custom background
        snackBarView.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
        snackBarView
            .setBackgroundTint(resources.getColor(backgroundColor, null))
            .setTextColor(resources.getColor(textColor, null))
            .show()
       // Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    protected fun setLoader(progress: View, state: Boolean) {
        when (state) {
            true -> progress.visibility = View.VISIBLE
            false -> progress.visibility = View.INVISIBLE
        }
    }
}