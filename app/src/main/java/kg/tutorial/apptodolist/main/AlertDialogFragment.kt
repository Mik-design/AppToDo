package kg.tutorial.apptodolist.main

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment


class AlertDialogFragment : DialogFragment() {


    companion object {
        private val TAG = "AlertDialogFragment"

        /*targetFragment?.let { fragment ->
            fragment.onActivityResult(fragment.targetRequestCode, Activity.RESULT_OK, null)
        }*/



        fun newInstance(message: String, positiveBtnText: String, negativeBtnText: String): AlertDialogFragment {
            val fragment = AlertDialogFragment()
            fragment.isCancelable = false

            val args = Bundle()
            args.putString("aMessage", message)
            args.putString("aPositiveBtnText", positiveBtnText)
            args.putString("aNegativeBtnText", negativeBtnText)

            fragment.arguments = args
            return fragment
        }


    }


    /*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d(TAG, "onCreateDialog called")
        super.onCreateDialog(savedInstanceState)
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(arguments?.getString("aMessage"))
                .setPositiveButton(arguments?.getString("aPositiveBtnText"), DialogInterface.OnClickListener { dialog, id ->
                    Log.d(TAG, "Yes!")
                })
                .setNegativeButton(arguments?.getString("aNegativeBtnText"), DialogInterface.OnClickListener { dialog, id ->
                    Log.d(TAG, "Dismiss!")
                })

            Log.d(TAG, "onCreateDialog ending")
            builder.create()
        } ?: throw IllegalStateException("Activity can not be null")
    }*/

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d(TAG, "onCreateDialog called")
        super.onCreateDialog(savedInstanceState)
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(arguments?.getString("aMessage"))
                .setPositiveButton(arguments?.getString("aPositiveBtnText"), DialogInterface.OnClickListener { dialog, id ->
                    Log.d(TAG, "Yes!")
                    targetFragment?.let { fragment ->
                        fragment.onActivityResult(fragment.targetRequestCode, Activity.RESULT_OK, null)
                    }
                })
                .setNegativeButton(arguments?.getString("aNegativeBtnText"), DialogInterface.OnClickListener { dialog, id ->
                    Log.d(TAG, "Dismiss!")
                })

            Log.d(TAG, "onCreateDialog ending")
            builder.create()
        } ?: throw IllegalStateException("Activity can not be null")
    }


    /*try {
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment().Companion.newInstance(
            "Would you like to continue?",
            "Yes",
            "Dismiss");
        alertDialogFragment.setTargetFragment(this, TARGET_FRAGMENT_REQUEST_CODE);
        alertDialogFragment.show(getActivity().getSupportFragmentManager(), "dialog");
    }catch (Exception e){
        e.printStackTrace();
    }
*/


}
