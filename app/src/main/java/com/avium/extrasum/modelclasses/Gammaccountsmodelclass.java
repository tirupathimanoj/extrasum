package com.avium.extrasum.modelclasses;

public class Gammaccountsmodelclass {
    float[] graphs;
    Integer profilrpic;
    String rank;
    String tradinggroup;
    String sinceyears;
    String investors;
    String percentage;
    String gainweek;
    String capital;
    String equity;
    String depslots;

    public Gammaccountsmodelclass(float[] graphs, Integer profilrpic, String rank, String tradinggroup, String sinceyears, String investors, String percentage, String gainweek, String capital, String equity, String depslots) {
        this.graphs = graphs;
        this.profilrpic = profilrpic;
        this.rank = rank;
        this.tradinggroup = tradinggroup;
        this.sinceyears = sinceyears;
        this.investors = investors;
        this.percentage = percentage;
        this.gainweek = gainweek;
        this.capital = capital;
        this.equity = equity;
        this.depslots = depslots;
    }

    public float[] getGraphs() {
        return graphs;
    }

    public void setGraphs(float[] graphs) {
        this.graphs = graphs;
    }

    public Integer getProfilrpic() {
        return profilrpic;
    }

    public void setProfilrpic(Integer profilrpic) {
        this.profilrpic = profilrpic;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTradinggroup() {
        return tradinggroup;
    }

    public void setTradinggroup(String tradinggroup) {
        this.tradinggroup = tradinggroup;
    }

    public String getSinceyears() {
        return sinceyears;
    }

    public void setSinceyears(String sinceyears) {
        this.sinceyears = sinceyears;
    }

    public String getInvestors() {
        return investors;
    }

    public void setInvestors(String investors) {
        this.investors = investors;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getGainweek() {
        return gainweek;
    }

    public void setGainweek(String gainweek) {
        this.gainweek = gainweek;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getEquity() {
        return equity;
    }

    public void setEquity(String equity) {
        this.equity = equity;
    }

    public String getDepslots() {
        return depslots;
    }

    public void setDepslots(String depslots) {
        this.depslots = depslots;
    }


}
