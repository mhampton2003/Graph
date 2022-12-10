//Maya Hampton
//This is my own work

package project8;

import java.util.Scanner;

public class Graph {
	
	//returns the neighbors of the entered index
	public void getNeighbor(int x, int[][] edges, String[] vertices) {
		
		System.out.println("Vertices next to " + vertices[x] + ":");
		
		for (int i = 0; i < 15; i++) {
			//if the index has a value print out the name associated with the index
			if (edges[x][i] > 0) {
				System.out.println(vertices[i]);
			}
		}
	}
	
	//returns the distance between two vertices
	public int getDistance(int start, int end, int[][] edges) {
		int total = 0;
		int n = end;
		
		//if there is a direct path between the two vertices return the distance
		if (edges[start][n] > 0) {
			total = edges[start][n];
			return total;
		}
		
		//keep going while there is not a direct path between the two vertices
		while (edges[start][n] == 0) {
			n++;
			
			//if n reaches end of the matrix, go back to the beginning
			if (n > 14) {
				n = 0;				
			}
			
			//add the current edge to the total distance
			total = total + edges[start][n];
		
			//if there is a direct path between the two vertices
			if (edges[start][n] > 0) {
				//start from where it previously ended
				start = n;
				
				//if the end vertices is at index 13 or 14, don't change n
				if (end >= 13) {
					//if n is 13 or 14, quit the for loop
					if (n == 13 || n == 14) {
						break;
					}
				}
				//otherwise check if there is a direct path between the new vertices
				else {
					n = end;
				}
				
			}
		}

		//add the final path to the total distance
		total = total + edges[start][end];
		
		return total;
	}
	
	//prints out adjacency matrix
	public void print(int[][] edges) {
		//print out each value in a 15 x 15 matrix format
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(edges[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		Scanner scnr = new Scanner(System.in);
		
		String[] vertices = new String[15];
		int[][] edges = new int[15][15];
		
		//initializes vertices
		vertices[0] = "Mohave";
		vertices[1] = "Coconino";
		vertices[2] = "Navajo";
		vertices[3] = "Apache";
		vertices[4] = "Greenlee";
		vertices[5] = "Cochise";
		vertices[6] = "Santa Cruz";
		vertices[7] = "Pima";
		vertices[8] = "Pinal";
		vertices[9] = "Graham";
		vertices[10] = "Gila";
		vertices[11] = "Yavapai";
		vertices[12] = "La Paz";
		vertices[13] = "Yuma";
		vertices[14] = "Maricopa";
		
		//initializes edges
		edges[0][1] = 14;
		edges[0][11] = 14;
		edges[0][12] = 9;
		
		edges[1][0] = 14;
		edges[1][11] = 9;
		edges[1][10] = 17;
		edges[1][2] = 9;
		
		edges[2][1] = 9;
		edges[2][10] = 13;
		edges[2][9] = 20;
		edges[2][3] = 5;
		
		edges[3][2] = 5;
		edges[3][9] = 19;
		edges[3][4] = 17;
		
		edges[4][3] = 17;
		edges[4][9]= 4;
		edges[4][5] = 16;
		
		edges[5][4] = 16;
		edges[5][9] = 12;
		edges[5][7] = 9;
		edges[5][6] = 8;
		
		edges[6][5] = 8;
		edges[6][7] = 6;
		
		edges[7][6] = 6;
		edges[7][5] = 9;
		edges[7][9] = 12;
		edges[7][8] = 7;
		edges[7][14] = 10;
		edges[7][13] = 23;
		
		edges[8][7] = 7;
		edges[8][9] = 13;
		edges[8][10] = 5;
		edges[8][14] = 6;
		
		edges[9][3] = 19;
		edges[9][4] = 4;
		edges[9][5] = 12;
		edges[9][7] = 12;
		edges[9][8] = 13;
		edges[9][10] = 7;
		edges[9][2] = 20;
		
		edges[10][9] = 7;
		edges[10][8] = 5;
		edges[10][14] = 8;
		edges[10][11] = 18;
		edges[10][1] = 17;
		edges[10][2] = 13;
		
		edges[11][1] = 9;
		edges[11][0] = 14;
		edges[11][12] = 15;
		edges[11][14] = 9;
		edges[11][10] = 18;
		
		edges[12][0] = 9;
		edges[12][11] = 15;
		edges[12][14] = 15;
		edges[12][13] = 11;
		
		edges[13][12] = 11;
		edges[13][14] = 18;
		edges[13][7] = 23;
		
		edges[14][12] = 15;
		edges[14][11] = 9;
		edges[14][10] = 8;
		edges[14][8] = 6;
		edges[14][7] = 10;
		edges[14][13] = 18;
		
		graph.print(edges);
		
		System.out.println("what index would you like to see the neighbors of?");
		
		int userInput = scnr.nextInt();
		
		if (userInput < 0 || userInput > 14) {
			System.out.println("Invalid index. Try again within the range of 0-14");
		}
		else {
			graph.getNeighbor(userInput, edges, vertices);
		}
		
		System.out.println("what indexes would you like to see the distance between?");
		System.out.print("enter beginning index: ");
		
		int userInputBeg = scnr.nextInt();
		
		System.out.print("enter end index: ");
		
		int userInputEnd = scnr.nextInt();

		if (userInputBeg < 0 || userInputBeg > 14 || userInputEnd < 0 || userInputEnd > 14) {
			System.out.println("Invalid index. Try again within the range of 0-14");
		}
		else {
			System.out.println(graph.getDistance(userInputBeg, userInputEnd, edges));
		}
	}
}
