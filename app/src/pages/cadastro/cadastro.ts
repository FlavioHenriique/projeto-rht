import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';
import { HttpClient } from '@angular/common/http';

@IonicPage()
@Component({
  selector: 'page-cadastro',
  templateUrl: 'cadastro.html',
})
export class CadastroPage {

  private empresa: any = { nome: "", codigo: "" };
  private url: string = "http://localhost:8085/empresas/";

  constructor(public navCtrl: NavController,
    public navParams: NavParams,
    public http: HttpClient,
    public alertCtrl: AlertController) {
  }

  cadastrar() {
    this.http.post(this.url, this.empresa, { observe: 'response' }).subscribe(res => {
      if (res.status == 200) {
        this.alerta("OK", "A empresa " + this.empresa.nome + " foi cadastrada!");
      }
    }, err => {
      if (err.status == 409) {
        this.alerta("Opa...", "Este código já pertence a outra empresa");
      }
    });
  }

  alerta(titulo, msg) {
    this.alertCtrl.create({
      title: titulo,
      subTitle: msg,
      buttons: ['Ok']
    }).present();
  }
}
