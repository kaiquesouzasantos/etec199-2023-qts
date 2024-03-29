import { retornaUsuario } from './functionsHTTP.js'
import { Validacao } from './validacao.js'
import { Usuario } from './usuario.js'

document.addEventListener(
    'mouseover', () => {
        let usuario = retornaUsuario()

        if(!new Validacao(usuario).validacao())
            window.location.href = 'http://127.0.0.1:5500/index.html'
        else
            carregaInformacoesUsuario(usuario)
    }
)

function carregaInformacoesUsuario(usuario){
    document.getElementById('txtNome').value = usuario.nome
    document.getElementById('txtCPF').value = usuario.cpf
    document.getElementById('txtRendimentos').value = 'R$'+usuario.rendimentos
    document.getElementById('txtAliquota').value = usuario.aliquota+'%'
    document.getElementById('txtParcela').value = 'R$'+usuario.parcela
}