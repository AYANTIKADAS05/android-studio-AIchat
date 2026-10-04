package com.example.myapplicationayantika

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MyAIchat : AppCompatActivity() {

    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button
    private lateinit var micButton: Button
    private lateinit var chatContainer: LinearLayout
    private lateinit var chatScroll: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_aichat)

        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)
        micButton = findViewById(R.id.micButton)
        chatContainer = findViewById(R.id.chatContainer)
        chatScroll = findViewById(R.id.chatScroll)

        // Send button
        sendButton.setOnClickListener {

            val message = messageInput.text.toString().trim()

            if (message.isNotEmpty()) {

                addMessage(message, true)

                messageInput.text.clear()

                // Temporary AI reply
                addMessage("Message received 😊", false)
            }
        }

        // Microphone button
        micButton.setOnClickListener {
            startVoiceInput()
        }
    }

    private fun addMessage(
        text: String,
        isUser: Boolean
    ) {

        val textView = TextView(this)

        textView.text = text
        textView.textSize = 16f

        textView.setPadding(
            20,
            15,
            20,
            15
        )

        if (isUser) {

            textView.setTextColor(Color.WHITE)

            textView.setBackgroundColor(
                Color.rgb(90, 60, 45)
            )

        } else {

            textView.setTextColor(Color.BLACK)

            textView.setBackgroundColor(
                Color.WHITE
            )
        }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        params.setMargins(
            0,
            8,
            0,
            8
        )

        textView.layoutParams = params

        chatContainer.addView(textView)

        // Scroll to the latest message
        chatScroll.post {
            chatScroll.fullScroll(
                ScrollView.FOCUS_DOWN
            )
        }
    }

    private fun startVoiceInput() {

        if (!SpeechRecognizer.isRecognitionAvailable(this)) {

            Toast.makeText(
                this,
                "Voice recognition is not available",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val intent = Intent(
            RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        )

        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )

        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE,
            "en-US"
        )

        intent.putExtra(
            RecognizerIntent.EXTRA_PROMPT,
            "Speak..."
        )

        startActivityForResult(
            intent,
            100
        )
    }

    @Deprecated("Deprecated in Android API")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {

        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )

        if (
            requestCode == 100 &&
            resultCode == RESULT_OK
        ) {

            val results =
                data?.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS
                )

            if (!results.isNullOrEmpty()) {

                messageInput.setText(
                    results[0]
                )
            }
        }
    }
}