import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';
import { Questao } from '../../model/Questao';
import { HttpClient } from '@angular/common/http';
import { Empresa } from '../../model/Empresa';
import { HomePage } from '../home/home';
import { GraficoPage } from '../grafico/grafico';

@IonicPage()
@Component({
  selector: 'page-questao',
  templateUrl: 'questao.html',
})
export class QuestaoPage {
  private empresa: Empresa = {};
  private questoes: any = {};
  private questao: Questao = {};
  private posicao: number;
  private respostas: string[] = [];
  private selecao: string = "";
  private url: string = "http://localhost:8085/questoes/";

  constructor(public navCtrl: NavController, public navParams: NavParams,
    public alertCtrl: AlertController, public http: HttpClient) {

    this.empresa = navParams.get('empresa');
    this.posicao = navParams.get("posicao");
    if (this.posicao == null) {
      this.buscarQuestoes();
    } else {
      this.questoes = navParams.get("questoes");
      this.respostas = navParams.get("respostas");
      this.questao = this.questoes[this.posicao];
      this.posicao = this.questao.posicao;
    }
  }

  buscarQuestoes() {
    this.http.get(this.url, { observe: 'response' }).subscribe(res => {
      if (res.status == 200) {
        this.questoes = res.body;
        this.questao = this.questoes[0];
        this.posicao = this.questao.posicao;
      }
    });
  }

  proximaQuestao() {
    if (this.selecao == "") {
      this.alerta("Opa...", "Selecione alguma opção!");
    } else {
      console.log(this.selecao);
      this.respostas.push(this.selecao);
      this.navCtrl.push(QuestaoPage, {
        "empresa": this.empresa,
        "posicao": this.questao.posicao,
        "questoes": this.questoes,
        "respostas": this.respostas
      });
    }

  }

  ehUltima() {
    return this.questoes.length == this.posicao;
  }

  enviarResultado() {
    if (this.selecao == "") {
      this.alerta("Opa...", "Selecione alguma opção!");
    } else {
      this.respostas.push(this.selecao);
      let resposta = {
        'estrategia': this.maisVotado(this.respostas),
        'empresa': this.empresa
      };
      let urlResposta = "http://localhost:8085/respostas/";
      this.http.post(urlResposta, resposta, { observe: 'response' }).subscribe(res => {
        if (res.status = 200) {
          this.alerta('OK, Suas respostas foram enviadas!', this.avaliacao(resposta.estrategia));
          this.navCtrl.push(GraficoPage, { empresa: this.empresa });
          //this.navCtrl.popAll();
        }
      });
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

  maisVotado(selecoes) {
    let max = 0;
    let cont;
    let resp = "";
    for (let k = 0; k < selecoes.length; k++) {
      cont = 0;
      for (let i = 0; i < selecoes.length; i++) {
        if (selecoes[k] == selecoes[i]) {
          cont++;
        }
      }
      if (cont > max) {
        max = cont;
        resp = selecoes[k];
      }
    }
    return resp;
  }

  avaliacao(resultado) {
    return "Segundo suas respostas, a estratégia de resolução de conflito "
      + "na qual você se encaixa é a " + resultado + "!";
  }
}
