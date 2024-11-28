# Sistema de Gerenciamento de Produtos

![Java](https://img.shields.io/badge/Java-17-orange)
![Status](https://img.shields.io/badge/Status-Stable-green)
![License](https://img.shields.io/badge/License-MIT-blue)

## 📋 Descrição
Sistema de gerenciamento de produtos utilizando Java, com funcionalidades de CRUD (Criar, Ler, Atualizar, Deletar) e armazenamento em memória. Desenvolvido como parte de um projeto acadêmico para gerenciamento de produtos em uma loja.
## 🎯 Funcionalidades

- Cadastro de produtos
- Busca por ID
- Listagem de todos os produtos
- Atualização de produtos
- Exclusão de produtos
- Busca por nome (parcial)
- Busca por categoria
- Interface colorida para melhor experiência do usuário

## 🔧 Tecnologias Utilizadas

- Java 22+
- Programação Orientada a Objetos
- Tratamento de Exceções

## 📁 Estrutura do Projeto

```
src/
└── com/
    └── loja/
        ├── modelo/
        │   └── Produto.java
        ├── gerenciador/
        │   └── GerenciadorProdutos.java
        ├── ui/
        │   └── MenuProdutos.java
        ├── util/
        ├── exception/
        │   ├── ProdutoException.java
        │   └── ValidacaoException.java
        └── Main.java
```

## 📌 Classes Principais

### Produto (model)
- Representa a entidade Produto
- Atributos: id, nome, preço, quantidade em estoque, categoria
- Validações de dados

### GerenciadorProdutos (manager)
- Gerencia todas as operações relacionadas a produtos
- Implementa operações CRUD e buscas especializadas
- Mantém a lista de produtos em memória

### MenuProdutos (ui)
- Interface com o usuário via console
- Gerencia entrada/saída de dados

## 🚀 Como Executar

1. **Requisitos**
    - Java JDK 17 ou superior

2. **Compilação**
   ```bash
   javac -d bin src/com/loja/**/*.java
   ```

3. **Execução**
   ```bash
   java -cp bin com.loja.Main
   ```

## 💻 Uso do Sistema

### Menu Principal
```
=== Menu de Produtos ===
1. Cadastrar Produto
2. Buscar Produto por ID
3. Listar Todos os Produtos
4. Atualizar Produto
5. Deletar Produto
6. Buscar por Nome
7. Buscar por Categoria
8. Sair
```

## 🔍 Validações

O sistema implementa as seguintes validações:

- **Nome**:
    - Não pode ser vazio
    - Mínimo de 2 caracteres

- **Preço**:
    - Deve ser maior que zero
    - Deve ser um número válido

- **Quantidade**:
    - Não pode ser negativa
    - Deve ser um número inteiro

- **Categoria**:
    - Não pode ser vazia

## 🤝 Contribuindo

Para contribuir com o projeto:

1. Faça um fork do repositório
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👤 Autor

Sanatiel Murceski

## 📞 Suporte

Para suporte, envie um email para sanatielmurceski@estudante.sesisenai.org.br

## 🔄 Status do Projeto

O projeto está em desenvolvimento ativo e aberto para contribuições.
