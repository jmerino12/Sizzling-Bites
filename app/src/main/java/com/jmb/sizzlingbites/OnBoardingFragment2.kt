import com.jmb.sizzlingbites.R


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jmb.sizzlingbites.OnBoardingFragment1

class OnBoardingFragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding2, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                OnBoardingFragment2().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}