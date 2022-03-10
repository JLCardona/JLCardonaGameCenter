package com.example.jlcardonagamecenter.jlcardona2048;

/**
 * Contenedor donde represento un conjunto de campos del juego.
 */
public class FieldsContainer {

    /** Dimensión (d x d) */
    private final int dimension;

    /** Campos*/
    private final Integer[][] fields;

    /**
     * Crea un nuevo contenedor de campos.
     * @param dimension Dimensión de los campos (d x d).
     */
    public FieldsContainer(int dimension) {
        this.dimension = dimension;
        this.fields = new Integer[dimension][dimension];
    }

    /**
     * Crea una copia del contenedor anterior.
     * @param copy Contenedor para hacer una copia.No se altera.
     */
    public FieldsContainer(FieldsContainer copy){
        this(copy.getDimension());
        this.copyFields(copy.getFields());
    }

    private void copyFields(Integer[][] fields) {
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                this.setField(i, j, fields[i][j]);
            }
        }
    }

    public void setField(int top, int left, Integer value) {
        this.fields[top][left] = value;
    }

    public Integer getField(int top, int left) {
        return this.fields[top][left];
    }

    public int getDimension(){
        return this.dimension;
    }

    public Integer[][] getFields(){
        return this.fields;
    }
}
