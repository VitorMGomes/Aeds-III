#include <stdio.h>

typedef enum {
    jan, feb, mar, apr, may, jun,
    jul, aug, sep, oct, nov, dec
} Mes;

typedef struct {
    Mes m;
    int d;
} Data;

int main() {
    Data dia = {jan, 1};
    printf("%d/%d\n", dia.m + 1, dia.d);

    dia.d = 29;
    dia.m = feb;

    printf("%d/%d\n", dia.m + 1, dia.d);

    return 0;
}



