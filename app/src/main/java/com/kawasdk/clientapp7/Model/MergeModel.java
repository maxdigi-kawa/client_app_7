
package com.kawasdk.clientapp7.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MergeModel {

    @SerializedName("response")
    @Expose
    private List<ResponseKawa> responseKawa = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("farms_fetched_at")
    @Expose
    private String farmsFetchedAt;
    @SerializedName("recipe_id")
    @Expose
    private String recipeId;

    public List<ResponseKawa> getResponse() {
        return responseKawa;
    }

    public void setResponse(List<ResponseKawa> responseKawa) {
        this.responseKawa = responseKawa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFarmsFetchedAt() {
        return farmsFetchedAt;
    }

    public void setFarmsFetchedAt(String farmsFetchedAt) {
        this.farmsFetchedAt = farmsFetchedAt;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }


}
