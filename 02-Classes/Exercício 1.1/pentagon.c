#include <stdio.h>

typedef struct {
    int x, y;
    int sides;
    int internalAngle;
    int w, h;
} Pentagon;

void print(Pentagon* p);

int main() {
    Pentagon p1 = {6, 4, 5, 108, 20, 18};
    print(&p1);
    
    return 0;
}

void print(Pentagon* p) {
    printf("O pentagono regular possui %d lados iguais e esta na posicao (%d,%d).\n", p->sides, p->x, p->y);
    printf("A figura tem tamanho igual a %dx%d com angulos internos iguais a %d.\n", p->w, p->h, p->internalAngle);
}
