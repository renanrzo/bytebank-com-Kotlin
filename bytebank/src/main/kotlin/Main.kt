fun main() {
    println("Bem vindo ao Bytebank")

    val contaRenan = Conta(titular = "Renan", numero = 1000)
    contaRenan.deposita(200.0)

    val contaMari = Conta(numero = 1001, titular = "Mari")
    contaMari.deposita(300.0)

    println(contaMari.titular)
    println(contaMari.numero)
    println(contaMari.saldo)

    println(contaRenan.titular)
    println(contaRenan.numero)
    println(contaRenan.saldo)

    println("depositando na conta do Renan")
    contaRenan.deposita(50.0)
    println(contaRenan.saldo)

    println("depositando na conta da Mari")
    contaMari.deposita(70.0)
    println(contaMari.saldo)

    println("sacando na conta do Renan")
    contaRenan.saca(250.0)
    println(contaRenan.saldo)

    println("sacando na conta da Mari")
    contaMari.saca(100.0)
    println(contaMari.saldo)

    println("saque em excesso na conta do Renan")
    contaRenan.saca(100.0)
    println(contaRenan.saldo)

    println("saque em excesso na conta da Mari")
    contaMari.saca(500.0)
    println(contaMari.saldo)

    println("TransferĂȘncia da conta da Mari para o Renan")

    if (contaMari.transfere(destino = contaRenan, valor = 300.0)) {
        println("TransferĂȘncia bem sucedida")
    } else {
        println("Falha na transferĂȘncia")
    }

    println(contaRenan.saldo)
    println(contaMari.saldo)
}

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta("JoĂŁo", 1002)
    contaJoao.titular = "JoĂŁo"
    var contaMaria = Conta("Maria", 1003)
    contaMaria.titular = "Maria"
    contaJoao.titular = "JoĂŁo"

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}

fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular: String = "Renan $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("nĂșmero da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
        i++
    }

    for (i in 5 downTo 1) {
        val titular: String = "Renan $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("nĂșmero da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta Ă© positiva")
    } else if (saldo == 0.0) {
        println("conta Ă© neutra")
    } else {
        println("conta Ă© negativa")
    }

    when {
        saldo > 0.0 -> println("conta Ă© positiva")
        saldo == 0.0 -> println("conta Ă© neutra")
        else -> println("conta Ă© negativa")
    }
}