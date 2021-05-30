#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

typedef struct Rect {
    int x, y, w, h;
    void (* print) (struct Rect*);
    void (* drag) (struct Rect*, int dx, int dy);
} Rect;

Rect* rect_new (int x, int y, int w, int h) {
    Rect* this = malloc(sizeof(Rect));
    this->drag = rect_drag;
    this->print = rect_print;
    this->x = x;
    this->y = y;
    this->w = w;
    this->h = h;
}

void rect_drag (Rect* this, int dx, int dy) {
    this->x += dx;
    this->y += dy;
}

void rect_print (Rect* this) {
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this->w, this->h, this->x, this->y);
}