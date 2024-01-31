package com.pico.mvvm.practicando

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposableTesting(viewModel: ViewModelMainActivity = hiltViewModel()) {
    Scaffold(
        topBar = {},
        content = {
            viewModel.practicingRegex()
            viewModel.solution(intArrayOf(1, 3, 6, 4, 1, 2))
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(text = "${viewModel.addingTwoNumbers(4, 6)}")
                Text(
                    modifier = Modifier.padding(top = 25.dp),
                    text = viewModel.multiplicationTable(9)
                )
                Text(
                    modifier = Modifier.padding(top = 50.dp),
                    text = viewModel.factorialNumber(5)
                )
                Text(
                    modifier = Modifier.padding(top = 75.dp),
                    text = viewModel.reverseString("hola me llamo andres")
                )
                Text(
                    modifier = Modifier.padding(top = 90.dp),
                    text = "${viewModel.contVowels("cuenta las vocales bellaco")}"
                )
                Text(
                    modifier = Modifier.padding(top = 105.dp),
                    text = "Es palindromo ${viewModel.itsPalyndrome("noooo")}"
                )
                Text(
                    modifier = Modifier.padding(top = 120.dp),
                    text = "Ordenado ${viewModel.orderList(listOf(1,45,215,6,7,85,23))}"
                )
            }

        },
        bottomBar = {},
    )
}