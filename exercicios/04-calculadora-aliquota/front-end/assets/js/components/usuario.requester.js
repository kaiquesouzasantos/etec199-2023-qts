import { Pattern } from "./usuario.pattern.js"

export class Requester {
  static async retornaUsuarioViaURL() {
    const urlParams = new URLSearchParams(window.location.search)

    return await this.retornaUsuario(
      urlParams.get("txtNome"),
      urlParams.get("numberRendimentos"),
      Pattern.retornaCPF(urlParams.get("txtCPF"))
    )
  }

  static async retornaUsuario(nome, rendimentos, cpf) {
    const url = 'http://localhost:8080/aliquota';
    return (await fetch(`${url}?nome=${nome}&rendimentos=${rendimentos}&cpf=${cpf}`)).json()
  }
}