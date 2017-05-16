package utfpr.ct.dainf.exemplo;

import java.util.Iterator;
import java.util.Stack;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * 
 * Exemplo de implementação de árvore binária.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 * @param <E> O tipo do elemento armazenado na árvore
 */
public class BinaryTree<E> implements Iterable<E> {
    
    private E value;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    /**
     * Cria uma árvore binária com valor nulo na raiz.
     */
    public BinaryTree() {
    }

    /**
     * Cria uma árvore binária com valor {@code value} na raiz.
     * @param value O valor do nó raiz
     */
    public BinaryTree(E value) {
        this.value = value;
    }
    
    /**
     * Adiciona um nó à esquerda do nó corrente.
     * @param e O valor do nó esquerdo.
     * @return A árvore adicionada ao nó
     */
    public BinaryTree<E> addLeft(E e) {
        left = new BinaryTree<>(e);
        return left;
    }
    
    /**
     * Adiciona um nó à direita do nó corrente.
     * @param e O valor do nó direito.
     * @return A árvore adicionada ao nó
     */
    public BinaryTree<E>  addRight(E e) {
        right = new BinaryTree<>(e);
        return right;
    }

    /**
     * Retorna o valor do nó.
     * @return O valor do nó.
     */
    public E getValue() {
        return value;
    }

    /**
     * Atribui um valor ao nó.
     * @param value O valor do nó.
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * Retorna a árvore esqueda.
     * @return A árvore esquerda.
     */
    public BinaryTree<E> getLeft() {
        return left;
    }

    /**
     * Retorna a árvore direita.
     * @return A árvore direita.
     */
    public BinaryTree<E> getRight() {
        return right;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new InOrderIterator<>(this);
    }
    
    /**
     * Classe interna: Iterador que retorna os nós da árvore em "in-order".
     * In-order: Visitar árvore esqueda, visitar raiz, visitar árvore direita.
     * @param <E> O tipo do elemento da árvore
     */
    private class InOrderIterator<E> implements Iterator<E> {
        Stack<BinaryTree<E>> s = new Stack<>();
        BinaryTree<E> node;

        public InOrderIterator(BinaryTree<E> root) {
            this.node = root;
        }

        @Override
        public boolean hasNext() {
            return !s.isEmpty() || node != null;
        }

        @Override
        public E next() {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            E value = node.value;
            node = node.right;
            return value;
        }
    }

}
