#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

int main () {
    Rect* r1 = rect_new(10, 20, 30, 30);
    rect_print(r1);

    Rect* r2 = rect_new(40, 50, 60, 60);
    rect_drag(r2, 10, 100);
    rect_print(r2);

    free(r1);
    free(r2);

    return 0;
}