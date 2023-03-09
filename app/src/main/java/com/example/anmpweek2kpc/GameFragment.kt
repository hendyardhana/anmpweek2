package com.example.anmpweek2kpc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import org.w3c.dom.Text


class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName

            val playerTurn = view.findViewById<TextView>(R.id.txtTurn)
            playerTurn.text = "$playerName's Turn"
        }

        var num1 = (0..50).random()
        var num2 = (0..50).random()
        var hasil = num1+num2

        val txtnum = view.findViewById<TextView>(R.id.txtNumber)
        val txtanswer = view.findViewById<EditText>(R.id.editInput)

        txtnum.text = "$num1 + $num2"

        var score = 0
        val backBtn = view.findViewById<Button>(R.id.btnSubmit)
        backBtn.setOnClickListener {
            if(txtanswer.text.toString() == hasil.toString()){
                score += 1
                num1 = (0..50).random()
                num2 = (0..50).random()
                hasil = num1+num2
                txtnum.text = "$num1 + $num2"
                Toast.makeText(activity, "Score: $score", Toast.LENGTH_SHORT).show()
                txtanswer.setText("")
            }
            else{
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}