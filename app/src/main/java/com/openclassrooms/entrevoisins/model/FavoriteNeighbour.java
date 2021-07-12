package com.openclassrooms.entrevoisins.model;

public class FavoriteNeighbour {

    /** Identifier */
    private long favoriteId;

    /** Full name */
    private String favoriteName;

    /** Avatar */
    private String favoriteAvatar;

    public FavoriteNeighbour() {
    }

    public FavoriteNeighbour(long favoriteId, String favoriteName, String favoriteAvatar) {
        this.favoriteId = favoriteId;
        this.favoriteName = favoriteName;
        this.favoriteAvatar = favoriteAvatar;
    }

    public long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getFavoriteName() {
        return favoriteName;
    }

    public void setFavoriteName(String favoriteName) {
        this.favoriteName = favoriteName;
    }

    public String getFavoriteAvatar() {
        return favoriteAvatar;
    }

    public void setFavoriteAvatar(String favoriteAvatar) {
        this.favoriteAvatar = favoriteAvatar;
    }
}
