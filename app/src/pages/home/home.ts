import { Component } from '@angular/core';
import { NavController, IonicPage, AlertController } from 'ionic-angular';
import { SobrePage } from '../sobre/sobre';
import { CadastroPage } from '../cadastro/cadastro';
import { HttpClient } from '@angular/common/http';
import { QuestaoPage } from '../questao/questao';
import { GraficoPage } from '../grafico/grafico';
import { Empresa } from '../../model/Empresa';


@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})

export class HomePage {

  private codigo: number;
  private url: string = "http://localhost:8085/empresas/";
  private empresa: Empresa = null;

  constructor(public navCtrl: NavController,
    public alertCtrl: AlertController,
    public http: HttpClient
  ) {

  }

  sobre() {
    this.navCtrl.push(SobrePage, {});
  }

  cadastro() {
    this.navCtrl.push(CadastroPage, {});
  }

  login() {
    let busca = this.url + "login/" + this.codigo;
    this.http.get(busca, { observe: 'response' }).subscribe(res => {
      if (res.status == 200) {
        let empresa = res.body;
        this.navCtrl.push(QuestaoPage, { 'empresa': empresa });
      } else {
        this.alerta("Opa...", "Não foi encontrada uma empresa com esse código");
      }
    });

  }

  

  alerta(titulo, msg) {
    this.alertCtrl.create({
      title: titulo,
      subTitle: msg,
      buttons: ['Ok']
    })
      .present();
  }

}
