
import java.util.Iterator;
import utfpr.ct.dainf.exemplo.BinaryTree;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * 
 * Cria e percorre a seguinte árvore binária:
 *       
 *                    A
 *                   / \
 *                  /   \
 *                 B     C
 *                / \   / \
 *               D   E F   G 
 *
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Main {
    public static void main(String[] args) {
        // cria a raiz da árvore binária
        BinaryTree<Character> tree = new BinaryTree<>('A');
        
        // adiciona os demais nós à árvore
        BinaryTree<Character> left = tree.addLeft('B');
        BinaryTree<Character> right = tree.addRight('C');
        left.addLeft('D');
        left.addRight('E');
        right.addLeft('F');
        right.addRight('G');
        
        // percore a árvore in-order
        System.out.println("USANDO ITERADOR");
        Iterator<Character> it = tree.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        System.out.println("USANDO FOREACH");
        for (Character c: tree) {
            System.out.println(c);
        }
    }
}
