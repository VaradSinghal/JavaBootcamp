public final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) {
        if(speciesName == null || speciesName.isEmpty()) throw new IllegalArgumentException("Invalid species name");
        if(evolutionStages == null || evolutionStages.length == 0) throw new IllegalArgumentException("Evolution stages required");
        if(maxLifespan <= 0) throw new IllegalArgumentException("Lifespan must be positive");
        if(habitat == null || habitat.isEmpty()) throw new IllegalArgumentException("Habitat required");

        this.speciesName = speciesName;
        this.evolutionStages = evolutionStages.clone(); // defensive copy
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() { return speciesName; }
    public String[] getEvolutionStages() { return evolutionStages.clone(); } // defensive copy
    public int getMaxLifespan() { return maxLifespan; }
    public String getHabitat() { return habitat; }

    @Override
    public String toString() {
        return speciesName + " [" + String.join(" -> ", evolutionStages) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof PetSpecies)) return false;
        PetSpecies other = (PetSpecies)o;
        return speciesName.equals(other.speciesName);
    }

    @Override
    public int hashCode() {
        return speciesName.hashCode();
    }
}
