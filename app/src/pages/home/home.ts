import { Component } from '@angular/core';
import { NavController, IonicPage, AlertController } from 'ionic-angular';
import { SobrePage } from '../sobre/sobre';
import { CadastroPage } from '../cadastro/cadastro';


@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})

export class HomePage {

  private codigo: number;

  constructor(public navCtrl: NavController, public alertCtrl: AlertController) {

  }

  sobre() {
    this.navCtrl.push(SobrePage, {});
  }

  cadastro() {
    this.navCtrl.push(CadastroPage, {});
  }

  login() {
    if(false){
      
      this.alerta("Opa...", "Não foi encontrada uma empresa com o código " + this.codigo + "!");
    }else{
      
    }
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
