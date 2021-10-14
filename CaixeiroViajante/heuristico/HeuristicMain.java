
public class HeuristicMain {
	public static void main(String[] args) {
        System.out.println(" si1032.tsp : ");
        int[][] testaMatriz = FileWorker.extrairMatrizDeAdjacencia("../cidades/_si1032.tsp.txt", 1032, false);
        Heuristic heuristic = new Heuristic(testaMatriz, 1032);
        heuristic.calculaHeuristica();
        
        System.out.println("");
        
        System.out.println(" pa561.tsp : ");
        testaMatriz = FileWorker.extrairMatrizDeAdjacencia("../cidades/_pa561.tsp.txt", 561, true);
        heuristic = new Heuristic(testaMatriz, 561);
        heuristic.calculaHeuristica();
        
        System.out.println("");
        
        System.out.println(" si535.tsp : ");
        testaMatriz = FileWorker.extrairMatrizDeAdjacencia("../cidades/_si535.tsp.txt", 535, false);
        heuristic = new Heuristic(testaMatriz, 535);
        heuristic.calculaHeuristica();
    }
}