package com.pico.mvvm.practicando

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelMainActivity @Inject constructor(): ViewModel() {

    init {
    }

    fun addingTwoNumbers(a: Int, b: Int): Int{
        val arrayList = ArrayList<Int>()
        return a + b
    }

    fun multiplicationTable(a : Int): String{
        var allMultiples = ""
        for(i in 1..10){
            allMultiples += " ${a*i}"
        }
        return allMultiples
    }

    fun factorialNumber(a: Int): String{
        var factorial = ""
        var changedA = a
        for (i in a-1 downTo 0 ){
            factorial = "${changedA}"
            changedA *= i
        }
        return factorial
    }


    fun reverseString(a: String): String{
        return a.reversed()
    }

    fun contVowels(a : String): Int{
        var listOfVowels = listOf<Char>('a','e','i','o','u')
        var cont = 0
        for(i in a){
            if(listOfVowels.contains(i)){
                cont++
            }
        }
        return cont

    }
    fun itsPalyndrome(a: String): Boolean{
        var isPalyndrome = false
        if(a.equals(reverseString(a))){
            isPalyndrome = true
        }

        return isPalyndrome
    }

    fun orderList(list: List<Int>): List<Int>{
        var hola: String = list.sorted().toString()

        return  list.sorted()
    }

    fun practicingRegex(){
        var pattern = Regex("younes", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","${pattern.containsMatchIn("hello Younes from")}")
        // que contenga alguna de esas letras antes, o sea e a , b, c
        pattern = Regex("[abc]younes", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","${pattern.containsMatchIn("hello cYounes from")}")
        pattern = Regex("youn[eaio]s", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","${pattern.containsMatchIn("hello Younbs from")}")
        // lo mismo pero desde la a a la k, un rango
        pattern = Regex("youn[a-k]s", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","${pattern.containsMatchIn("hello Younbs from")}")
        // es la negacio ^ de los caracteres a, e, i , o , u
        pattern = Regex("youn[^aeiou]s", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","${pattern.containsMatchIn("hello Younbs from")}")
        // si queremos buscar una palabra, (DEBE CONTENER) ya no solo que contenga una letra, si no más de una de usa (hola), esto significa
        // que buscara todos los caracteres que contengan hola, si no lo contiene dara falso
        pattern = Regex("yo(un)es", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","yo(un)es =  , ${pattern.containsMatchIn("hello Younes from")}")
        // busca lo mismo el caracter (un) obligatorio, pero con * lo busca más de una vez
        pattern = Regex("yo(un)*es", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","yo(un)*es =  , ${pattern.containsMatchIn("hello Younununes from")}")
        // si ^ esta afuera de [] al inicio del string significa que si o si tiene que empezar con alguno de los caracteres dentro de []
        pattern = Regex("^[yz]o(un)*es", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","^[yz]o(un)*es = inicia , ${pattern.containsMatchIn("Younes")}")
        Log.d("ViewModelMainActivity","^[yz]o(un)*es = no inicia , ${pattern.containsMatchIn("bounes ")}")
        // y el $ es parecido a ^pero es para finalizar
        pattern = Regex("^[yz]o(un)*e[sk]$", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","^[yz]o(un)*e[sea]$ = finaliza , ${pattern.containsMatchIn("Younes")}")
        Log.d("ViewModelMainActivity","^[yz]o(un)*e[sea]\$ = no finaliza , ${pattern.containsMatchIn("Younej ")}")
        // el | es un or puede ser lo que este a la izquierda o a la derecha
        pattern = Regex("^[yz]o(un)*e(slk|012)$", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","^[yz]o(un)*e(slk|012)$ = or finaliza , ${pattern.containsMatchIn("Youne012")}")
        Log.d("ViewModelMainActivity","^[yz]o(un)*e(slk|012)$ = or no finaliza , ${pattern.containsMatchIn("Younej ")}")
        // el . acepta cualquier caracter noimporta si es un numero o un hexadecimal , aceptara de todo
        pattern = Regex("y.n", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","y.n = or finaliza , ${pattern.containsMatchIn("y1n")}")
        pattern = Regex("y.*n", RegexOption.IGNORE_CASE)
        Log.d("ViewModelMainActivity","y.*n = or no finaliza , ${pattern.containsMatchIn("yassgjaiogjasn ")}")
    }

    fun solution(A: IntArray): Int{

        var list:ArrayList<Int> = A.toCollection(ArrayList())
        list.sort()
        var cont = list.firstOrNull()
        for (i in list){
            if (cont != null) {
                if(i > cont && i == cont+1){
                    return cont+1
                }
            }
        }
        return 0;
    }
}
