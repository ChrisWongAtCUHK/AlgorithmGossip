#include <stdio.h>
#define SIZE 8

typedef struct {
	int x;
	int y;
} Step;

Step step(int, int);
void travel(int[][SIZE], Step);
void possible(int[][SIZE], Step, int*);
int count(int*);
Step get(Step, int*, int);
Step hard(int[][SIZE], Step, int*);
int isVisitable(int[][SIZE], Step);

int main(void){
	int board[SIZE][SIZE] = {0};
	travel(board, step(5,6));

	int i;
	for(i = 0; i < SIZE; i++){
		int j;
		for(j = 0; j < SIZE; j++){
			printf("%3d", board[i][j]);
		}

		printf("\n");
	}

}

Step step(int x, int y){
	Step s = {x, y};
	return s;
}

void travel(int board[][SIZE], Step start){
	board[start.x][start.y] = 1;
	Step current = start;

	int s;
	for(s = 2; s < 65; s++){
		int possibleSteps[SIZE] = {0};
		possible(board, current, possibleSteps);

		int c = count(possibleSteps);
		if(c == 0){
			break;
		} else if (c == 1){
			current = get(current, possibleSteps, 1);
		} else {
			current = hard(board, current, possibleSteps);
		}

		board[current.x][current.y] = s;

	}
}

void possible(int board[][SIZE], Step current, int* possibleSteps){
	int dirs[8][2] = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1},
					  {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

	int i;
	for(i = 0; i < SIZE; i++){
		Step s = step(current.x + dirs[i][0], current.y + dirs[i][1]);
		if(isVisitable(board, s)){
			possibleSteps[i] = 1;
		}
	}
}

int count(int* possibleSteps){
	int c, i;
	for(c = 0, i = 0; i < SIZE; i++){
		if(possibleSteps[i]){
			c++;
		}
	}

	return c;
}

Step get(Step current, int* possibleSteps, int number){
	int dirs[8][2] = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1},
					  {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

	int c, i;
	for(c = 0, i = 0; i < SIZE; i++){
		if(possibleSteps[i]){
			c++;
			if(c == number){
				break;
			}
		}
	}

	return step(current.x + dirs[i][0], current.y + dirs[i][1]);
	
}

Step hard(int board[][SIZE], Step current, int* possibleSteps){
	int minPossibleSteps[SIZE] = {0};
	possible(board, get(current, possibleSteps, 1), minPossibleSteps);
	
	int minIndex, i;
	for(minIndex = 0, i = 1; i < count(possibleSteps); i++){
		int nextPossibleSteps[SIZE] = {0};
		Step s = get(current, possibleSteps, i + 1);
		possible(board, s, nextPossibleSteps);
		if(count(nextPossibleSteps) < count(minPossibleSteps)){
			minIndex = i;
			int j;
			for(j = 0; j < SIZE; j++){
				minPossibleSteps[j] = nextPossibleSteps[j];
			}
		}
	}
	return get(current, possibleSteps, minIndex + 1);
}

int isVisitable(int board[][SIZE], Step step){
	return step.x > -1 && step.x < SIZE && 
		   step.y > -1 && step.y < SIZE &&
		   !board[step.x][step.y];
}


