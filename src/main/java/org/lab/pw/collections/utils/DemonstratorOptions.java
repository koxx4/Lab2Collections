package org.lab.pw.collections.utils;

public class DemonstratorOptions {
    private int dataSetSize;
    private boolean isDataConsistent;
    private boolean areDeepDuplicatedValuesGuaranteed;

    public DemonstratorOptions(int dataSetSize, boolean isDataConsistent, boolean areDeepDuplicatedValuesGuaranteed) {
        this.dataSetSize = dataSetSize;
        this.isDataConsistent = isDataConsistent;
        this.areDeepDuplicatedValuesGuaranteed = areDeepDuplicatedValuesGuaranteed;
    }

    public DemonstratorOptions() {
    }

    public int getDataSetSize() {
        return dataSetSize;
    }

    public void setDataSetSize(int dataSetSize) {
        this.dataSetSize = dataSetSize;
    }

    public boolean isDataConsistent() {
        return isDataConsistent;
    }

    public void setDataConsistent(boolean dataConsistent) {
        isDataConsistent = dataConsistent;
    }

    public boolean isAreDeepDuplicatedValuesGuaranteed() {
        return areDeepDuplicatedValuesGuaranteed;
    }

    public void setAreDeepDuplicatedValuesGuaranteed(boolean isDuplicatedValuesGuaranteed) {
        this.areDeepDuplicatedValuesGuaranteed = isDuplicatedValuesGuaranteed;
    }

    @Override
    public String toString() {
        return "DemonstratorOptions{\n" +
                "dataSetSize=" + dataSetSize +
                "\n, isDataConsistent=" + isDataConsistent +
                "\n, areDeepDuplicatedValuesGuaranteed=" + areDeepDuplicatedValuesGuaranteed +
                "\n}";
    }
}
