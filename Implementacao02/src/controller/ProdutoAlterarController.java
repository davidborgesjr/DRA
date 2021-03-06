/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Produto;
import view.TelaAlterarProduto;

/**
 *
 * @author davidborges
 */
public class ProdutoAlterarController {
    private final TelaAlterarProduto telaAlterarProduto;
    private final ProdutoDAO dao;
    private final Produto produto;
    
    //Construtor
    public ProdutoAlterarController(Produto produtoAlterar){
        this.produto = produtoAlterar;
        this.telaAlterarProduto = new TelaAlterarProduto(produto);
        this.telaAlterarProduto.setVisible(true);        
        this.telaAlterarProduto.btnAlterarListener(new btnAlterarListener());
        this.telaAlterarProduto.btnVoltarListener(new btnVoltarListener());
        this.dao = new ProdutoDAO();
    }
    
    //Evento do botão Alterar
    class btnAlterarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           AlterarProduto();
        }        
    }
    public void AlterarProduto(){
        if(this.dao.alterarProduto(this.telaAlterarProduto.getProduto())){
            this.telaAlterarProduto.exibirMensagem("Produto alterado com sucesso!");
            this.telaAlterarProduto.setVisible(false);            
            ProdutoPrincipalController controle = new ProdutoPrincipalController();
        }else{
            this.telaAlterarProduto.exibirMensagem("Não foi possível alteradar o produto!");
        };
    }
    
    //Evento do botão Voltar
    class btnVoltarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            BotaoVoltar();
            
        }        
    }
    public void BotaoVoltar(){
        this.telaAlterarProduto.setVisible(false);
         ProdutoPrincipalController controle = new ProdutoPrincipalController();
    }
    
}
