package kg.tutorial.apptodolist.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kg.tutorial.apptodolist.R
import kg.tutorial.apptodolist.databinding.ImportantgoalsBinding
import java.util.*

class ImportantGoals : Fragment(), AdapterView.OnItemSelectedListener{

    private var _binding: ImportantgoalsBinding? = null
    private val binding: ImportantgoalsBinding get() = _binding!!

    var states = arrayOf("None", "Low", "Medium", "High")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ImportantgoalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinner.setOnItemSelectedListener(this)

        val arr = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, states)
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = arr

        binding.mic.setOnClickListener {
            checkAudioPermission()
            // changing the color of mic icon, which
            // indicates that it is currently listening
            binding.mic.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.mic_enabled_color
                )
            ) // #FF0E87E7
            startSpeechToText("NAME")
        }
        binding.micOne.setOnClickListener {
            checkAudioPermission()
            // changing the color of mic icon, which
            // indicates that it is currently listening
            binding.micOne.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.mic_enabled_color
                )
            ) // #FF0E87E7
            startSpeechToText("DESC")
        }
        val date = Calendar.getInstance()
        binding.start.setOnClickListener {
            DatePickerDialog(requireContext(),
                { view, year, month, dayOfMonth ->
                    //set start date
                },
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        binding.finish.setOnClickListener {
            DatePickerDialog(requireContext(),
                { view, year, month, dayOfMonth ->
                    //set finish date
                },
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }


    private fun startSpeechToText(type: String) {
        val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireContext())
        val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechRecognizerIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        if (type == "NAME") {
            speechRecognizer.setRecognitionListener(goalNameRecognitionListener)
        } else {
            speechRecognizer.setRecognitionListener(goalDescRecognitionListener)
        }
        speechRecognizer.startListening(speechRecognizerIntent)
    }

    val goalNameRecognitionListener = object : RecognitionListener {
        override fun onReadyForSpeech(bundle: Bundle?) {}
        override fun onBeginningOfSpeech() {}
        override fun onRmsChanged(v: Float) {}
        override fun onBufferReceived(bytes: ByteArray?) {}
        override fun onEndOfSpeech() {
            // changing the color of our mic icon to
            // gray to indicate it is not listening
            binding.mic.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.mic_disabled_color
                )
            ) // #FF6D6A6A
        }

        override fun onError(i: Int) {}

        override fun onResults(bundle: Bundle) {
            val result = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
//                val result_one = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            if (result != null) {
                // attaching the output
                // to our textview
                binding.goalName.setText(result[0].toString())
/*

                    if (result_one !=null) {
                        binding.goalDesc.setText(result_one[0].toString())
*/

            }
        }


        override fun onPartialResults(bundle: Bundle) {}
        override fun onEvent(i: Int, bundle: Bundle?) {}

    }

    val goalDescRecognitionListener = object : RecognitionListener {
        override fun onReadyForSpeech(bundle: Bundle?) {}
        override fun onBeginningOfSpeech() {}
        override fun onRmsChanged(v: Float) {}
        override fun onBufferReceived(bytes: ByteArray?) {}
        override fun onEndOfSpeech() {
            // changing the color of our mic icon to
            // gray to indicate it is not listening
            binding.micOne.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.mic_disabled_color
                )
            ) // #FF6D6A6A
        }

        override fun onError(i: Int) {}

        override fun onResults(bundle: Bundle) {
            val result = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
//                val result_one = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            if (result != null) {
                // attaching the output
                // to our textview
                binding.goalDesc.setText(result[0].toString())
/*

                    if (result_one !=null) {
                        binding.goalDesc.setText(result_one[0].toString())
*/

            }
        }


        override fun onPartialResults(bundle: Bundle) {}
        override fun onEvent(i: Int, bundle: Bundle?) {}

    }

    private fun checkAudioPermission() {

        // M = 23
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                "android.permission.RECORD_AUDIO") != PackageManager.PERMISSION_GRANTED
        ) {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:kg.tutorial.apptodolist")
            )
            startActivity(intent)
            Toast.makeText(requireContext(), "Allow Microphone Permission", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        binding.msg.text = "Selected : " + states[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    companion object {
        fun newInstance(): ImportantGoals = ImportantGoals()
    }
}

