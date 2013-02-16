package GUI;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Negocios.Funcionario;
import Negocios.Telefone;
import Repositorio.RepositorioFuncionarioArray;
import Repositorio.RepositorioTelefoneArray;

public class Cadastro implements ActionListener {
    private final RepositorioFuncionarioArray rFuncionarios;
    private final RepositorioTelefoneArray rTelefones;
    private final int quantidadeFuncionarios = 10;
    private final int quantidadeTelefones = 15;

    JFrame appFrame;


    JLabel jlbName, jlbAddress, jlbPhone, jlbEmail;
    JLabel jlbNome, jlbCpf, jlbFone, jlbDesc;
    JTextField jtfNome, jtfCpf, jtfFone, jtfDesc;
    JButton jbnSalvar, jbnRemover, jbnClear, jbnAtualizar, jbnPesquisar, jbnExit;

    String nome, cpf, telefone, descricao;

    Container cPane;

    public static void main(String args[]) {
        new Cadastro();
    }

    public Cadastro() {
        nome = "";
        cpf = "";
        descricao = "";
        telefone = "";
        createGUI();


        rFuncionarios = new RepositorioFuncionarioArray(quantidadeFuncionarios);
        rTelefones = new RepositorioTelefoneArray(quantidadeTelefones);

    }

    public void createGUI() {

   		/*Create a frame, get its contentpane and set layout*/
        appFrame = new JFrame("Cadrastro Cin/Motorola");

        cPane = appFrame.getContentPane();
        cPane.setLayout(new GridBagLayout());

        //Arrange components on contentPane and set Action Listeners to each JButton
        arranjarComponentes();

        appFrame.setSize(340, 300);
        appFrame.setResizable(false);
        appFrame.setVisible(true);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void arranjarComponentes() {
        jlbNome = new JLabel("Nome");
        jlbCpf = new JLabel("CPF");
        jlbFone = new JLabel("Telefone");
        jlbDesc = new JLabel("Descrição");

        jtfNome = new JTextField(20);
        jtfCpf = new JTextField(20);
        jtfFone = new JTextField(20);
        jtfDesc = new JTextField(20);

        jbnSalvar = new JButton("Salvar");
        jbnRemover = new JButton("Remover");
        jbnClear = new JButton("Limpar campos");
        jbnAtualizar = new JButton("Atualizar");
        jbnPesquisar = new JButton("Pesquisar");

        jbnExit = new JButton("Sair");

   		/*add all initialized components to the container*/
        GridBagConstraints gridBagConstraintsx01 = new GridBagConstraints();
        gridBagConstraintsx01.gridx = 0;
        gridBagConstraintsx01.gridy = 0;
        gridBagConstraintsx01.insets = new Insets(5, 5, 5, 5);
        cPane.add(jlbNome, gridBagConstraintsx01);

        GridBagConstraints gridBagConstraintsx02 = new GridBagConstraints();
        gridBagConstraintsx02.gridx = 1;
        gridBagConstraintsx02.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx02.gridy = 0;
        gridBagConstraintsx02.gridwidth = 2;
        gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
        cPane.add(jtfNome, gridBagConstraintsx02);

        GridBagConstraints gridBagConstraintsx03 = new GridBagConstraints();
        gridBagConstraintsx03.gridx = 0;
        gridBagConstraintsx03.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx03.gridy = 1;
        cPane.add(jlbCpf, gridBagConstraintsx03);

        GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
        gridBagConstraintsx04.gridx = 1;
        gridBagConstraintsx04.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx04.gridy = 1;
        gridBagConstraintsx04.gridwidth = 2;
        gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
        cPane.add(jtfCpf, gridBagConstraintsx04);

        GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
        gridBagConstraintsx05.gridx = 0;
        gridBagConstraintsx05.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx05.gridy = 2;
        cPane.add(jlbFone, gridBagConstraintsx05);

        GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
        gridBagConstraintsx06.gridx = 1;
        gridBagConstraintsx06.gridy = 2;
        gridBagConstraintsx06.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx06.gridwidth = 2;
        gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
        cPane.add(jtfFone, gridBagConstraintsx06);

        GridBagConstraints gridBagConstraintsx07 = new GridBagConstraints();
        gridBagConstraintsx07.gridx = 0;
        gridBagConstraintsx07.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx07.gridy = 3;
        cPane.add(jlbDesc, gridBagConstraintsx07);

        GridBagConstraints gridBagConstraintsx08 = new GridBagConstraints();
        gridBagConstraintsx08.gridx = 1;
        gridBagConstraintsx08.gridy = 3;
        gridBagConstraintsx08.gridwidth = 2;
        gridBagConstraintsx08.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx08.fill = GridBagConstraints.BOTH;
        cPane.add(jtfDesc, gridBagConstraintsx08);

        GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
        gridBagConstraintsx09.gridx = 0;
        gridBagConstraintsx09.gridy = 4;
        gridBagConstraintsx09.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnSalvar, gridBagConstraintsx09);

        GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
        gridBagConstraintsx10.gridx = 1;
        gridBagConstraintsx10.gridy = 4;
        gridBagConstraintsx10.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnRemover, gridBagConstraintsx10);

        GridBagConstraints gridBagConstraintsx11 = new GridBagConstraints();
        gridBagConstraintsx11.gridx = 2;
        gridBagConstraintsx11.gridy = 4;
        gridBagConstraintsx11.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnAtualizar, gridBagConstraintsx11);

        GridBagConstraints gridBagConstraintsx13 = new GridBagConstraints();
        gridBagConstraintsx13.gridx = 1;
        gridBagConstraintsx13.gridy = 5;
        gridBagConstraintsx13.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnPesquisar, gridBagConstraintsx13);

        GridBagConstraints gridBagConstraintsx15 = new GridBagConstraints();
        gridBagConstraintsx15.gridx = 1;
        gridBagConstraintsx15.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx15.gridy = 6;
        cPane.add(jbnClear, gridBagConstraintsx15);

        GridBagConstraints gridBagConstraintsx16 = new GridBagConstraints();
        gridBagConstraintsx16.gridx = 2;
        gridBagConstraintsx16.gridy = 6;
        gridBagConstraintsx16.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnExit, gridBagConstraintsx16);

        jbnSalvar.addActionListener(this);
        jbnRemover.addActionListener(this);
        jbnClear.addActionListener(this);
        jbnAtualizar.addActionListener(this);
        jbnPesquisar.addActionListener(this);
        jbnExit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbnSalvar) {
            inserirFuncionario();
            limparFoneInfo();
        } else if (e.getSource() == jbnRemover) {
            removerFuncionario();
            limpar();
        } else if (e.getSource() == jbnAtualizar) {
            atualizarFuncionario();
            limpar();
        } else if (e.getSource() == jbnPesquisar) {
            procurarFuncionario();
        } else if (e.getSource() == jbnClear) {
            limpar();
        } else if (e.getSource() == jbnExit) {
            System.exit(0);
        }

    }

    public void inserirFuncionario() {
        nome = jtfNome.getText();
        cpf = jtfCpf.getText();
        telefone = jtfFone.getText();
        descricao = jtfDesc.getText();

        if (nome.equals("") || cpf.equals("") || telefone.equals("") || descricao.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor insira os dados corretamente.");
        } else {
            Funcionario func = new Funcionario(nome, cpf);
            Telefone fone = new Telefone(telefone, descricao, func.getId());
            try {
                System.out.println(cpf);
                if (rFuncionarios.existe(cpf)) {
                    System.out.println("existe");
                    // Apenas atualiza telefone
                    rTelefones.inserir(fone);
                    System.out.println(rTelefones.getPosGravar());
                } else {
                    // Insere novo funcionario e telefone
                    rFuncionarios.inserir(func);
                    rTelefones.inserir(fone);
                    System.out.println(rFuncionarios.existe(cpf));
                }
                JOptionPane.showMessageDialog(null, "Funcionario Salvo.\nAltere apenas os campos telefone e descrição para adicionar novo telefone");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Limite de armazenamento atingido");
            }

        }
    }

    public void removerFuncionario() {

        cpf = jtfCpf.getText();
        if (cpf.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor insira um cpf de funcionario para deletar.");
        } else {
            try {
                rFuncionarios.remover(cpf);
                JOptionPane.showMessageDialog(null, "Registro apagado com sucesso");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public void atualizarFuncionario() {

        cpf = jtfCpf.getText();
        if (rFuncionarios.existe(cpf)) {
            nome = jtfNome.getText();
            telefone = jtfFone.getText();
            descricao = jtfDesc.getText();
            Funcionario funcionario = new Funcionario(nome, cpf);
            Telefone fone = new Telefone(telefone, descricao, funcionario.getId());

            try {
                rFuncionarios.atualizar(funcionario);
                rTelefones.atualizar(fone);
            } catch (Exception e) {
                // ja verificado no if
            }
            JOptionPane.showMessageDialog(null, "Funcionario atualizado.");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum funcionario encontrado com esse cpf.");
        }
    }

    public void procurarFuncionario() {

        cpf = jtfCpf.getText();

        if (cpf.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor insira um cpf para buscar o funcionario.");
        } else {
            Funcionario func = rFuncionarios.procurar(cpf);

            if (func == null) {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
                // Limpa os campos
                limpar();
            } else {
                Telefone[] telefones = rTelefones.listarTelefones(func.getId());
                Telefone fone = telefones[0];
                // Mostrar o resultado da busca nos campos
                jtfNome.setText(func.getNome());
                jtfCpf.setText(func.getCpf());
                jtfFone.setText(fone.getCodigo());
                jtfDesc.setText(fone.getDescricao());
            }
        }

    }

    public void limpar() {

        jtfNome.setText("");
        jtfCpf.setText("");
        jtfFone.setText("");
        jtfDesc.setText("");
    }

    public void limparFoneInfo() {

        jtfFone.setText("");
        jtfDesc.setText("");
    }


}