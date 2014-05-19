#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SWAP_FLAGS(x, y){ char temp; \
						temp = flags[x]; \
						flags[x] = flags[y]; \
						flags[y] = temp; }

void printFlags(char* flags) {
	int i;
	for(i = 0; i < strlen(flags); i++){
		printf("%c ", flags[i]);
	}
	printf("\n");

}

void adjust(char* flags){
	int w = 0;
	int b = 0;
	int r = strlen(flags) - 1;
	while(flags[w] == 'B' && w < strlen(flags)) { b++; w++; }
	while(flags[r] == 'R' && r > 0) { r--; }
	while(w <= r) switch(flags[w]){
		case 'W':
			w++;
			break;
		case 'B':
			SWAP_FLAGS(b, w);
			b++; w++;
			break;
		case 'R':
			SWAP_FLAGS(r, w);
			r--;
	}
}

int main(int argc, char* argv[]){
	char flags[] = {'R', 'W', 'B', 'W', 'W', 'B', 'R', 'B', 'W', 'R', '\0'};
	
	printFlags(flags);
	adjust(flags);
	printFlags(flags);
}

