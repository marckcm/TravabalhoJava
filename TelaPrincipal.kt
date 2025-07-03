import java.awt.Color
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.Font
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import java.util.logging.Level
import java.util.logging.Logger
import javax.swing.*
import javax.swing.event.ListSelectionEvent
import javax.swing.event.ListSelectionListener
import javax.swing.table.DefaultTableModel

/**
 * @author Marcelo de Castro Moreira
 * @author Marcelo de Castro Moreira
 * @author Marcelo de Castro Moreira
*/

class TelaPrincipal : JFrame() {
    // Adicione este método para preencher os campos quando uma linha é selecionada:
    private fun carregarDadosSelecionados() {
        val linhaSelecionada = tabelaPessoas!!.getSelectedRow()

        if (linhaSelecionada >= 0) {
            // Se uma linha foi selecionada obtém os dados da linha selecionada
            val id = tabelaPessoas!!.getValueAt(linhaSelecionada, 0) as Int
            val nome = tabelaPessoas!!.getValueAt(linhaSelecionada, 1) as String?
            val idade = tabelaPessoas!!.getValueAt(linhaSelecionada, 2) as Int
            val salario = tabelaPessoas!!.getValueAt(linhaSelecionada, 3) as Double

            // Preenche os campos
            txtNome!!.setText(nome)
            txtIdade!!.setText(idade.toString())
            txtSalario!!.setText(salario.toString())
        }
    }

    private fun atualizarTabela() {
        val model = tabelaPessoas!!.getModel() as DefaultTableModel
        model.setRowCount(0) // Limpa a tabela 

        val pessoas = PessoaDAO.listar()
        for (p in pessoas) {
            model.addRow(
                arrayOf<Any?>(
                    p.getId(),
                    p.getNome(),
                    p.getIdade(),
                    p.getSalario()
                )
            )
        }
    }

    private fun calcularMedia(valores: DoubleArray): Double {
        var soma = 0.0
        for (valor in valores) {
            soma += valor
        }
        return soma / valores.size
    }

    private fun calcularMedia(valores: IntArray): Int {
        var soma = 0
        for (valor in valores) {
            soma += valor
        }
        return soma / valores.size
    }

    private fun encontrarMaior(valores: DoubleArray): Double {
        var maior = valores[0]
        for (valor in valores) {
            if (valor > maior) {
                maior = valor
            }
        }
        return maior
    }

    private fun exibirRelatorio(dados: Array<Array<Any?>?>) {
        val frameRelatorio = JFrame("Relatório Completo")
        val tabelaRelatorio = JTable(dados, arrayOf<String>("", "", "", ""))
        // Desabilita edição
        tabelaRelatorio.setDefaultEditor(Any::class.java, null)
        // Rolagem
        val scrollPane = JScrollPane(tabelaRelatorio)
        frameRelatorio.add(scrollPane)
        frameRelatorio.setSize(600, 400)
        frameRelatorio.setLocationRelativeTo(null)
        frameRelatorio.setVisible(true)
    }

    /**
     * Este método é chamado de dentro do construtor para inicializar o
     * formulário. AVISO: NÃO modifique este código. O conteúdo deste método é
     * sempre regenerado pelo Editor de Formulários.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private fun initComponents() {
        txtNome = JTextField()
        txtIdade = JTextField()
        txtSalario = JTextField()
        jLabel1 = JLabel()
        jLabel2 = JLabel()
        jLabel3 = JLabel()
        btnInserir = JButton()
        btnAtualizar = JButton()
        btnExcluir = JButton()
        jScrollPane1 = JScrollPane()
        tabelaPessoas = JTable()
        btnRelatorio = JButton()
        jLabel4 = JLabel()
        jSeparator1 = JSeparator()
        jSeparator2 = JSeparator()
        jLabel5 = JLabel()
        jMenuBar1 = JMenuBar()
        menuEditar = JMenu()
        menuInserir = JMenuItem()
        menuAtualizar = JMenuItem()
        menuExcluir = JMenuItem()
        jSeparator3 = JPopupMenu.Separator()
        menuSair = JMenuItem()
        menuDados = JMenu()
        menuRelatorio = JMenuItem()

        setDefaultCloseOperation(EXIT_ON_CLOSE)
        setTitle("Formulário Principal")
        setBackground(Color(255, 255, 255))
        setForeground(Color.lightGray)

        txtNome!!.setToolTipText("")

        txtSalario!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                txtSalarioActionPerformed(evt)
            }
        })

        jLabel1!!.setFont(Font("Segoe UI", 0, 14)) // NOI18N
        jLabel1!!.setText("Nome:")

        jLabel2!!.setFont(Font("Segoe UI", 0, 14)) // NOI18N
        jLabel2!!.setText("Idade:")

        jLabel3!!.setFont(Font("Segoe UI", 0, 14)) // NOI18N
        jLabel3!!.setText("Salário:")

        btnInserir!!.setBackground(Color(153, 204, 255))
        btnInserir!!.setIcon(ImageIcon(javaClass.getResource("/img/add.png"))) // NOI18N
        btnInserir!!.setText("Inserir")
        btnInserir!!.setMaximumSize(Dimension(578, 519))
        btnInserir!!.setMinimumSize(Dimension(578, 519))
        btnInserir!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                btnInserirActionPerformed(evt)
            }
        })

        btnAtualizar!!.setBackground(Color(153, 204, 255))
        btnAtualizar!!.setIcon(ImageIcon(javaClass.getResource("/img/atualizar.png"))) // NOI18N
        btnAtualizar!!.setText("Atualizar")
        btnAtualizar!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                btnAtualizarActionPerformed(evt)
            }
        })

        btnExcluir!!.setBackground(Color(153, 204, 255))
        btnExcluir!!.setIcon(ImageIcon(javaClass.getResource("/img/delete.png"))) // NOI18N
        btnExcluir!!.setText("Excluir")
        btnExcluir!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                btnExcluirActionPerformed(evt)
            }
        })

        tabelaPessoas!!.setModel(object : DefaultTableModel(
            arrayOf<Array<Any?>?>(
                arrayOf<Any?>(null, null, null, null),
                arrayOf<Any?>(null, null, null, null),
                arrayOf<Any?>(null, null, null, null),
                arrayOf<Any?>(null, null, null, null)
            ),
            arrayOf<String>(
                "ID", "Nome", "Idade", "Salário"
            )
        ) {
            var types: Array<Class<*>?> = arrayOf<Class<*>>(
                Int::class.java, String::class.java, Int::class.java, Double::class.java
            ) as Array<Class<*>?>

            override fun getColumnClass(columnIndex: Int): Class<*>? {
                return types[columnIndex]
            }
        })
        tabelaPessoas!!.setName("") // NOI18N
        tabelaPessoas!!.setShowGrid(true)
        jScrollPane1!!.setViewportView(tabelaPessoas)

        btnRelatorio!!.setBackground(Color(153, 204, 255))
        btnRelatorio!!.setIcon(ImageIcon(javaClass.getResource("/img/relatorio.png"))) // NOI18N
        btnRelatorio!!.setText("Relatórios")
        btnRelatorio!!.setActionCommand("Relatorio")
        btnRelatorio!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                btnRelatorioActionPerformed(evt)
            }
        })

        jLabel4!!.setFont(Font("Segoe UI Symbol", 1, 24)) // NOI18N
        jLabel4!!.setText("Cadastro de Funcionário")

        jLabel5!!.setFont(Font("Segoe UI Semibold", 1, 24)) // NOI18N
        jLabel5!!.setText("Listagem de Funcionários Cadastrados")

        menuEditar!!.setText("Editar")

        menuInserir!!.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK))
        menuInserir!!.setIcon(ImageIcon(javaClass.getResource("/img/add.png"))) // NOI18N
        menuInserir!!.setText("Inserir")
        menuInserir!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                menuInserirActionPerformed(evt)
            }
        })
        menuEditar!!.add(menuInserir)

        menuAtualizar!!.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK))
        menuAtualizar!!.setIcon(ImageIcon(javaClass.getResource("/img/atualizar.png"))) // NOI18N
        menuAtualizar!!.setText("Atualizar")
        menuAtualizar!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                menuAtualizarActionPerformed(evt)
            }
        })
        menuEditar!!.add(menuAtualizar)

        menuExcluir!!.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK))
        menuExcluir!!.setIcon(ImageIcon(javaClass.getResource("/img/delete.png"))) // NOI18N
        menuExcluir!!.setText("Excluir")
        menuExcluir!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                menuExcluirActionPerformed(evt)
            }
        })
        menuEditar!!.add(menuExcluir)
        menuEditar!!.add(jSeparator3)

        menuSair!!.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_DOWN_MASK))
        menuSair!!.setIcon(ImageIcon(javaClass.getResource("/img/logout.png"))) // NOI18N
        menuSair!!.setText("Sair")
        menuSair!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                menuSairActionPerformed(evt)
            }
        })
        menuEditar!!.add(menuSair)

        jMenuBar1!!.add(menuEditar)

        menuDados!!.setText("Relatório")

        menuRelatorio!!.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK))
        menuRelatorio!!.setIcon(ImageIcon(javaClass.getResource("/img/relatorio.png"))) // NOI18N
        menuRelatorio!!.setText("Relatório")
        menuRelatorio!!.addActionListener(object : ActionListener {
            override fun actionPerformed(evt: ActionEvent?) {
                menuRelatorioActionPerformed(evt)
            }
        })
        menuDados!!.add(menuRelatorio)

        jMenuBar1!!.add(menuDados)

        setJMenuBar(jMenuBar1)

        val layout = GroupLayout(getContentPane())
        getContentPane().setLayout(layout)
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING)
                .addGroup(
                    GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.Companion.MAX_VALUE.toInt())
                        .addComponent(jLabel4)
                        .addGap(210, 210, 210)
                )
                .addComponent(jSeparator2)
                .addGroup(
                    layout.createSequentialGroup()
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(
                                    layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(
                                            jScrollPane1,
                                            GroupLayout.PREFERRED_SIZE,
                                            646,
                                            GroupLayout.PREFERRED_SIZE
                                        )
                                )
                                .addGroup(
                                    layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(jLabel5)
                                )
                        )
                        .addContainerGap(23, Short.Companion.MAX_VALUE.toInt())
                )
                .addGroup(
                    GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.Companion.MAX_VALUE.toInt())
                        .addComponent(
                            btnInserir,
                            GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE
                        )
                        .addGap(50, 50, 50)
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(
                                    layout.createSequentialGroup()
                                        .addGroup(
                                            layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel1)
                                        )
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(
                                            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                    txtSalario,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    111,
                                                    GroupLayout.PREFERRED_SIZE
                                                )
                                                .addComponent(
                                                    txtIdade,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    93,
                                                    GroupLayout.PREFERRED_SIZE
                                                )
                                                .addComponent(
                                                    txtNome,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    212,
                                                    GroupLayout.PREFERRED_SIZE
                                                )
                                        )
                                )
                                .addGroup(
                                    layout.createSequentialGroup()
                                        .addComponent(btnAtualizar)
                                        .addGap(50, 50, 50)
                                        .addComponent(btnExcluir)
                                        .addGap(50, 50, 50)
                                        .addComponent(btnRelatorio)
                                )
                        )
                        .addGap(55, 55, 55)
                )
        )
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                    layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.Companion.MAX_VALUE.toInt())
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(
                                    txtNome,
                                    GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(jLabel1)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(
                                    txtIdade,
                                    GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(jLabel2)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtSalario)
                        )
                        .addGap(22, 22, 22)
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(
                                    btnInserir,
                                    GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addGroup(
                                    layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnExcluir)
                                        .addComponent(btnRelatorio)
                                        .addComponent(btnAtualizar)
                                )
                        )
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()
                )
        )

        pack()
        setLocationRelativeTo(null)
    } // </editor-fold>//GEN-END:initComponents

    private fun txtSalarioActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_txtSalarioActionPerformed
        // TODO adicione seu código de manuseio aqui:
    } //GEN-LAST:event_txtSalarioActionPerformed

    private fun btnInserirActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_btnInserirActionPerformed
        try {
            // 1. Obter e validar campos não vazios 
            val nome = txtNome!!.getText().trim { it <= ' ' }
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "O campo Nome é obrigatório!",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtNome!!.requestFocus()
                return
            }

            // 2. Validar idade
            if (txtIdade!!.getText().trim { it <= ' ' }.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "O campo Idade é obrigatório!",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtIdade!!.requestFocus()
                return
            }

            // 3. Validar salário
            if (txtSalario!!.getText().trim { it <= ' ' }.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "O campo Salário é obrigatório!",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtSalario!!.requestFocus()
                return
            }

            // 4. Converter e validar tipos numéricos
            val idade: Int
            val salario: Double

            try {
                idade = txtIdade!!.getText().trim { it <= ' ' }.toInt()
            } catch (e: NumberFormatException) {
                JOptionPane.showMessageDialog(
                    this,
                    "Idade deve ser um número inteiro válido!",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtIdade!!.requestFocus()
                return
            }

            try {
                salario = txtSalario!!.getText().trim { it <= ' ' }.toDouble()
            } catch (e: NumberFormatException) {
                JOptionPane.showMessageDialog(
                    this,
                    "Salário deve ser um número válido!\nUse ponto como separador decimal.",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtSalario!!.requestFocus()
                return
            }

            // 5. Tentar criar e inserir a pessoa (validações adicionais ocorrerão no construtor)
            val novaPessoa = Pessoa(0, nome, idade, salario)
            PessoaDAO.inserir(novaPessoa)

            // 6. Atualizar interface
            atualizarTabela()
            limparCampos()

            JOptionPane.showMessageDialog(
                this,
                "Cadastro realizado com sucesso!",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE
            )
        } catch (e: IllegalArgumentException) {
            // Captura exceções lançadas pelo construtor de Pessoa 
            JOptionPane.showMessageDialog(
                this,
                e.message,
                "Erro de Validação", JOptionPane.ERROR_MESSAGE
            )
        }
    } //GEN-LAST:event_btnInserirActionPerformed

    private fun btnAtualizarActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_btnAtualizarActionPerformed
        val linhaSelecionada = tabelaPessoas!!.getSelectedRow()

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa para atualizar!")
            return
        }

        try {
            val id = tabelaPessoas!!.getValueAt(linhaSelecionada, 0) as Int
            val nome = txtNome!!.getText()
            val idade = txtIdade!!.getText().toInt()
            val salario = txtSalario!!.getText().toDouble()

            PessoaDAO.atualizar(Pessoa(id, nome, idade, salario))
            atualizarTabela()
            limparCampos()
        } catch (ex: NumberFormatException) {
            JOptionPane.showMessageDialog(this, "Idade e salário devem ser números válidos!")
        }
    } //GEN-LAST:event_btnAtualizarActionPerformed

    private fun btnExcluirActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_btnExcluirActionPerformed
        val linha = tabelaPessoas!!.getSelectedRow()
        if (linha < 0) {
            JOptionPane.showMessageDialog(
                this,
                "Selecione um registro na tabela para excluir",
                "Nenhum selecionado",
                JOptionPane.WARNING_MESSAGE
            )
            return
        }

        // Obtém todos os dados da linha selecionada
        val id = tabelaPessoas!!.getValueAt(linha, 0) as Int
        val nome = tabelaPessoas!!.getValueAt(linha, 1) as String?
        val idade = tabelaPessoas!!.getValueAt(linha, 2) as Int
        val salario = tabelaPessoas!!.getValueAt(linha, 3) as Double

        // Cria uma mensagem formatada
        val mensagem = String.format(
            ("<html><b>Confirmar exclusão do registro?</b><br><br>"
                    + "<table>"
                    + "<tr><td><b>ID:</b></td><td>%d</td></tr>"
                    + "<tr><td><b>Nome:</b></td><td>%s</td></tr>"
                    + "<tr><td><b>Idade:</b></td><td>%d anos</td></tr>"
                    + "<tr><td><b>Salário:</b></td><td>R$ %.2f</td></tr>"
                    + "</table></html>"),
            id, nome, idade, salario
        )

        val resposta = JOptionPane.showConfirmDialog(
            this,
            mensagem,
            "Confirmação de Exclusão",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        )

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                PessoaDAO.excluir(id)
                atualizarTabela()
                JOptionPane.showMessageDialog(
                    this,
                    "Registro excluído com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
                )
            } catch (e: Exception) {
                JOptionPane.showMessageDialog(
                    this,
                    "Erro ao excluir registro: " + e.message,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                )
            }
        }
    } //GEN-LAST:event_btnExcluirActionPerformed

    private fun btnRelatorioActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_btnRelatorioActionPerformed
        val pessoas = PessoaDAO.listar()
        if (pessoas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum dado para gerar relatório!")
            return
        }
        // 1. USO DE VETORES para cálculos estatísticos
        val salarios = DoubleArray(pessoas.size)
        val idades = IntArray(pessoas.size)
        for (i in pessoas.indices) {
            salarios[i] = pessoas.get(i).getSalario()
            idades[i] = pessoas.get(i).getIdade()
        }
        // Cálculos estatísticos
        val mediaSalarial = calcularMedia(salarios)
        val maiorSalario = encontrarMaior(salarios)
        val mediaIdade = calcularMedia(idades)
        // 2. USO DE MATRIZ para relatório completo
// Calcula o tamanho necessário: 5 linhas de cabeçalho + 1 linha de separação + N linhas de dados
        val totalLinhas = 6 + 1 + pessoas.size
        val dadosRelatorio = Array<Array<Any?>?>(totalLinhas) { arrayOfNulls<Any>(4) }
        // Cabeçalho
        dadosRelatorio[0]!![0] = "                 RELATÓRIO DE PESSOAS"
        dadosRelatorio[1]!![0] = "Total de registros: " + pessoas.size
        dadosRelatorio[2]!![0] = "Média salarial: " + String.format("R$ %.2f", mediaSalarial)
        dadosRelatorio[2]!![1] = "Maior salário: " + String.format("R$ %.2f", maiorSalario)
        dadosRelatorio[3]!![0] = "Média de idade: " + mediaIdade + " anos" // Linha em branco para separar (linha 4)
        dadosRelatorio[4]!![0] = ""
        dadosRelatorio[5]!![0] = "DETALHES:"
        // Cabeçalho da tabela (linha 5)
        dadosRelatorio[6]!![0] = "ID"
        dadosRelatorio[6]!![1] = "Nome"
        dadosRelatorio[6]!![2] = "Idade"
        dadosRelatorio[6]!![3] = "Salário"
        // Dados das pessoas (começando da linha 6)
        for (i in pessoas.indices) {
            val p = pessoas.get(i)
            dadosRelatorio[i + 7]!![0] = p.getId()
            dadosRelatorio[i + 7]!![1] = p.getNome()
            dadosRelatorio[i + 7]!![2] = p.getIdade()
            dadosRelatorio[i + 7]!![3] = p.getSalario()
        }
        // Exibir relatório em uma nova janela
        exibirRelatorio(dadosRelatorio)
    } //GEN-LAST:event_btnRelatorioActionPerformed

    private fun menuInserirActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_menuInserirActionPerformed
        try {
            // 1. Obter e validar campos não vazios 
            val nome = txtNome!!.getText().trim { it <= ' ' }
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "O campo Nome é obrigatório!",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtNome!!.requestFocus()
                return
            }

            // 2. Validar idade
            if (txtIdade!!.getText().trim { it <= ' ' }.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "O campo Idade é obrigatório!",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtIdade!!.requestFocus()
                return
            }

            // 3. Validar salário
            if (txtSalario!!.getText().trim { it <= ' ' }.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "O campo Salário é obrigatório!",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtSalario!!.requestFocus()
                return
            }

            // 4. Converter e validar tipos numéricos
            val idade: Int
            val salario: Double

            try {
                idade = txtIdade!!.getText().trim { it <= ' ' }.toInt()
            } catch (e: NumberFormatException) {
                JOptionPane.showMessageDialog(
                    this,
                    "Idade deve ser um número inteiro válido!",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtIdade!!.requestFocus()
                return
            }

            try {
                salario = txtSalario!!.getText().trim { it <= ' ' }.toDouble()
            } catch (e: NumberFormatException) {
                JOptionPane.showMessageDialog(
                    this,
                    "Salário deve ser um número válido!\nUse ponto como separador decimal.",
                    "Erro", JOptionPane.ERROR_MESSAGE
                )
                txtSalario!!.requestFocus()
                return
            }

            // 5. Tentar criar e inserir a pessoa (validações adicionais ocorrerão no construtor)
            val novaPessoa = Pessoa(0, nome, idade, salario)
            PessoaDAO.inserir(novaPessoa)

            // 6. Atualizar interface
            atualizarTabela()
            limparCampos()

            JOptionPane.showMessageDialog(
                this,
                "Cadastro realizado com sucesso!",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE
            )
        } catch (e: IllegalArgumentException) {
            // Captura exceções lançadas pelo construtor de Pessoa 
            JOptionPane.showMessageDialog(
                this,
                e.message,
                "Erro de Validação", JOptionPane.ERROR_MESSAGE
            )
        }
    } //GEN-LAST:event_menuInserirActionPerformed

    private fun menuAtualizarActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_menuAtualizarActionPerformed
        // TODO add your handling code here:
        val linha = tabelaPessoas!!.getSelectedRow()
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa!")
            return
        }

        val id = tabelaPessoas!!.getValueAt(linha, 0) as Int
        val nome = txtNome!!.getText()
        val idade = txtIdade!!.getText().toInt()
        val salario = txtSalario!!.getText().toDouble()

        PessoaDAO.atualizar(Pessoa(id, nome, idade, salario))
        atualizarTabela()
        limparCampos()
    } //GEN-LAST:event_menuAtualizarActionPerformed

    private fun menuExcluirActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_menuExcluirActionPerformed
        val linha = tabelaPessoas!!.getSelectedRow()
        if (linha < 0) {
            JOptionPane.showMessageDialog(
                this,
                "Selecione um registro na tabela para excluir",
                "Nenhum selecionado",
                JOptionPane.WARNING_MESSAGE
            )
            return
        }

        // Obtém todos os dados da linha selecionada
        val id = tabelaPessoas!!.getValueAt(linha, 0) as Int
        val nome = tabelaPessoas!!.getValueAt(linha, 1) as String?
        val idade = tabelaPessoas!!.getValueAt(linha, 2) as Int
        val salario = tabelaPessoas!!.getValueAt(linha, 3) as Double

        // Cria uma mensagem formatada
        val mensagem = String.format(
            ("<html><b>Confirmar exclusão do registro?</b><br><br>"
                    + "<table>"
                    + "<tr><td><b>ID:</b></td><td>%d</td></tr>"
                    + "<tr><td><b>Nome:</b></td><td>%s</td></tr>"
                    + "<tr><td><b>Idade:</b></td><td>%d anos</td></tr>"
                    + "<tr><td><b>Salário:</b></td><td>R$ %.2f</td></tr>"
                    + "</table></html>"),
            id, nome, idade, salario
        )

        val resposta = JOptionPane.showConfirmDialog(
            this,
            mensagem,
            "Confirmação de Exclusão",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        )

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                PessoaDAO.excluir(id)
                atualizarTabela()
                JOptionPane.showMessageDialog(
                    this,
                    "Registro excluído com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
                )
            } catch (e: Exception) {
                JOptionPane.showMessageDialog(
                    this,
                    "Erro ao excluir registro: " + e.message,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                )
            }
        }
    } //GEN-LAST:event_menuExcluirActionPerformed

    private fun menuSairActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_menuSairActionPerformed
        // TODO add your handling code here:
        System.exit(0)
    } //GEN-LAST:event_menuSairActionPerformed

    private fun menuRelatorioActionPerformed(evt: ActionEvent?) { //GEN-FIRST:event_menuRelatorioActionPerformed
        // TODO add your handling code here:
        val pessoas = PessoaDAO.listar()
        if (pessoas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum dado para gerar relatório!")
            return
        }
        // 1. USO DE VETORES para cálculos estatísticos
        val salarios = DoubleArray(pessoas.size)
        val idades = IntArray(pessoas.size)
        for (i in pessoas.indices) {
            salarios[i] = pessoas.get(i).getSalario()
            idades[i] = pessoas.get(i).getIdade()
        }
        // Cálculos estatísticos
        val mediaSalarial = calcularMedia(salarios)
        val maiorSalario = encontrarMaior(salarios)
        val mediaIdade = calcularMedia(idades)
        // 2. USO DE MATRIZ para relatório completo
// Calcula o tamanho necessário: 5 linhas de cabeçalho + 1 linha de separação + N linhas de dados
        val totalLinhas = 6 + 1 + pessoas.size
        val dadosRelatorio = Array<Array<Any?>?>(totalLinhas) { arrayOfNulls<Any>(4) }
        // Cabeçalho
        dadosRelatorio[0]!![0] = "                 RELATÓRIO DE PESSOAS"
        dadosRelatorio[1]!![0] = "Total de registros: " + pessoas.size
        dadosRelatorio[2]!![0] = "Média salarial: " + String.format("R$ %.2f", mediaSalarial)
        dadosRelatorio[2]!![1] = "Maior salário: " + String.format("R$ %.2f", maiorSalario)
        dadosRelatorio[3]!![0] = "Média de idade: " + mediaIdade + " anos" // Linha em branco para separar (linha 4)
        dadosRelatorio[4]!![0] = ""
        dadosRelatorio[5]!![0] = "DETALHES:"
        // Cabeçalho da tabela (linha 5)
        dadosRelatorio[6]!![0] = "ID"
        dadosRelatorio[6]!![1] = "Nome"
        dadosRelatorio[6]!![2] = "Idade"
        dadosRelatorio[6]!![3] = "Salário"
        // Dados das pessoas (começando da linha 6)
        for (i in pessoas.indices) {
            val p = pessoas.get(i)
            dadosRelatorio[i + 7]!![0] = p.getId()
            dadosRelatorio[i + 7]!![1] = p.getNome()
            dadosRelatorio[i + 7]!![2] = p.getIdade()
            dadosRelatorio[i + 7]!![3] = p.getSalario()
        }
        // Exibir relatório em uma nova janela
        exibirRelatorio(dadosRelatorio)
    } //GEN-LAST:event_menuRelatorioActionPerformed

    private fun limparCampos() {
        txtNome!!.setText("")
        txtIdade!!.setText("")
        txtSalario!!.setText("")
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var btnAtualizar: JButton? = null
    private var btnExcluir: JButton? = null
    private var btnInserir: JButton? = null
    private var btnRelatorio: JButton? = null
    private var jLabel1: JLabel? = null
    private var jLabel2: JLabel? = null
    private var jLabel3: JLabel? = null
    private var jLabel4: JLabel? = null
    private var jLabel5: JLabel? = null
    private var jMenuBar1: JMenuBar? = null
    private var jScrollPane1: JScrollPane? = null
    private var jSeparator1: JSeparator? = null
    private var jSeparator2: JSeparator? = null
    private var jSeparator3: JPopupMenu.Separator? = null
    private var menuAtualizar: JMenuItem? = null
    private var menuDados: JMenu? = null
    private var menuEditar: JMenu? = null
    private var menuExcluir: JMenuItem? = null
    private var menuInserir: JMenuItem? = null
    private var menuRelatorio: JMenuItem? = null
    private var menuSair: JMenuItem? = null
    private var tabelaPessoas: JTable? = null
    private var txtIdade: JTextField? = null
    private var txtNome: JTextField? = null
    private var txtSalario: JTextField? = null // Fim da declaração das variaveis

    /**
     Criando novo formulario TelaPrincipal
    */

    init {
        initComponents()
        atualizarTabela()
        // Adiciona o listener de seleção à tabela
        tabelaPessoas!!.getSelectionModel().addListSelectionListener(ListSelectionListener { e: ListSelectionEvent? ->
            if (!e!!.valueIsAdjusting) {
                // Evita duplicação de eventos
                carregarDadosSelecionados()
            }
        })
    }

    companion object {
        /**
         @param args the command line arguments
        */
        @JvmStatic
        fun main(args: Array<String>) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
            try {
                for (info in UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus" == info.getName()) {
                        UIManager.setLookAndFeel(info.getClassName())
                        break
                    }
                }
            } catch (ex: ClassNotFoundException) {
                Logger.getLogger(TelaPrincipal::class.java.getName()).log(Level.SEVERE, null, ex)
            } catch (ex: InstantiationException) {
                Logger.getLogger(TelaPrincipal::class.java.getName()).log(Level.SEVERE, null, ex)
            } catch (ex: IllegalAccessException) {
                Logger.getLogger(TelaPrincipal::class.java.getName()).log(Level.SEVERE, null, ex)
            } catch (ex: UnsupportedLookAndFeelException) {
                Logger.getLogger(TelaPrincipal::class.java.getName()).log(Level.SEVERE, null, ex)
            }

            //</editor-fold>

            /* Create and display the form */
            EventQueue.invokeLater(object : Runnable {
                override fun run() {
                    TelaPrincipal().setVisible(true)
                }
            })
        }
    }
}