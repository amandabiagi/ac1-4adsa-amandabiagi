package amandabiagi.ac1.models

class Cliente {
    var nome:String = "";
    var renda:Double = 0.0;
    var classeSocial:String = "";

    constructor(nome: String, renda: Double) {
        this.nome = nome
        this.renda = renda
    }


    fun calcularRenda(cliente: Cliente){
        when(cliente.renda){
            in 0..2900 -> cliente.classeSocial = "Pobre"
            in 2901..11999 -> cliente.classeSocial = "Classe Média"
            else -> cliente.classeSocial = "Rico"
        }
    }


}