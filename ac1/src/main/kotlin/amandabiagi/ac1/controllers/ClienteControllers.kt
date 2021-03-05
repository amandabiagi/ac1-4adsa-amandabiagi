package amandabiagi.ac1.controllers

import amandabiagi.ac1.models.Cliente
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/clientes")
class ClienteControllers {

    var listaCliente = mutableListOf<Cliente>()

    @PostMapping
    fun criarCliente(@RequestBody cliente:Cliente): ResponseEntity<String>{
        cliente.calcularRenda(cliente)
        listaCliente.add(cliente);

        println("Cliente adicionado com sucesso!")
        return ResponseEntity("Cliente adicionado com sucesso! ",HttpStatus.ACCEPTED)
    }

    @GetMapping("/todos")
    fun getAll():ResponseEntity<MutableList<Cliente>> {
        if (listaCliente.isEmpty()) {
            println("Não contém!")
            return ResponseEntity(HttpStatus.NO_CONTENT)
        } else
            println("Lista: " + listaCliente)
            return ResponseEntity(listaCliente, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id:Int):ResponseEntity<Cliente> {
        if (listaCliente.size < id) {
            println("Não contém!")
            return ResponseEntity(HttpStatus.NO_CONTENT)
        } else
            id - 1;
            println("Cliente: " + listaCliente.get(id))
        return ResponseEntity(listaCliente.get(id), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteOne(@PathVariable id:Int):ResponseEntity<String> {

        if (listaCliente.size < id) {
            println("Não contém!")
            return ResponseEntity("Não contém",HttpStatus.NO_CONTENT)

        } else
            println("Cliente deletado! ")
        id - 1;
        listaCliente.removeAt(id)

        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/mais-ricos")
    fun maisRicos():ResponseEntity<MutableList<Cliente>>{
        var clientesRicos =  mutableListOf<Cliente>()
        var resultado = listaCliente.filter {it.renda > 15000}

        for(cliente:Cliente in resultado){
            clientesRicos.add(cliente);
        }

        if (clientesRicos.isEmpty()) {
            println("Lista vazia")
            return ResponseEntity(clientesRicos, HttpStatus.NO_CONTENT)
        }else{
            println("Os mais ricos cadastrados ${clientesRicos}")
            return ResponseEntity(clientesRicos, HttpStatus.OK)
        }

    }

}




