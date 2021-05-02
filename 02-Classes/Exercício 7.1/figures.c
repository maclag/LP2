#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r, g, b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y, w, h;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

// Triangle

typedef struct {
    Figure super;
} Triangle;

void triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;

    printf("Triangulo de vertices em (%d,%d), (%d,%d) e (%d,%d).\n",
            sup->x + (sup->w)/2, sup->y, 
            sup->x + sup->w, sup->y + sup->h,
            sup->x, sup->y + sup->h);
}

Triangle* triangle_new (int x, int y, int w, int h) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) triangle_print;
    sup->x = x;
    sup->y = y;
    sup->w = w;
    sup->h = h;
}

///////////////////////////////////////////////////////////////////////////////

// Pentagon

typedef struct {
    Figure super;
} Pentagon;

void pentagon_print (Pentagon* this) {
    Figure* sup = (Figure*) this;

    printf("Pentagono de vertices em (%d,%d), (%d,%d), (%d,%d), (%d,%d) e (%d,%d).\n",
            sup->x + (sup->w)/2, sup->y,
            sup->x + sup->w, sup->y + (45*sup->h)/100,
            sup->x + (75*sup->w)/100, sup->y + sup->h,
            sup->x + (sup->w)/4, sup->y + sup->h,
            sup->x, sup->y + (45*sup->h)/100);
}

Pentagon* pentagon_new (int x, int y, int w, int h) {
    Pentagon* this = malloc(sizeof(Pentagon));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) pentagon_print;
    sup->x = x;
    sup->y = y;
    sup->w = w;
    sup->h = h;
}

///////////////////////////////////////////////////////////////////////////////

int main () {
    Figure* figs[4] = {
        (Figure*) triangle_new(10, 10, 100, 100),
        (Figure*) pentagon_new(40, 10, 140, 300),
        (Figure*) triangle_new(85, 50, 150, 65),
        (Figure*) pentagon_new(110, 110, 85, 130)
    };

    for (int i = 0; i < 4; i++) {
        figs[i]->print(figs[i]);
    }

    for (int i = 0; i < 4; i++) {
        free(figs[i]);
    }

    return 0;
}