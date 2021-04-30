package com.teamaurora.abundance.common.capability.deafness;

public class DefaultDeafnessCapability implements IDeafnessCapability {

    private boolean isDeaf;

    @Override
    public boolean isDeaf() {
        return this.isDeaf;
    }

    @Override
    public void setDeaf(boolean deaf) {
        this.isDeaf = deaf;
    }
}
