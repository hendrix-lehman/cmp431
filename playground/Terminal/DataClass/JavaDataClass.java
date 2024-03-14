class JavaDataClass {
  private int artistId;
  private int artistInfoId;
  private int titleId;
  private int yearId;
  private int descriptionId;
  private int artistBioId;
  private int artworkImageId;
  private int artistImageId;

  public JavaDataClass(int artistId, int artistInfoId, int titleId, int yearId, int descriptionId, int artistBioId,
      int artworkImageId, int artistImageId) {
    this.artistId = artistId;
    this.artistInfoId = artistInfoId;
    this.titleId = titleId;
    this.yearId = yearId;
    this.descriptionId = descriptionId;
    this.artistBioId = artistBioId;
    this.artworkImageId = artworkImageId;
    this.artistImageId = artistImageId;
  }

  public int getArtistId() {
    return artistId;
  }

  public int getArtistInfoId() {
    return artistInfoId;
  }

  public int getTitleId() {
    return titleId;
  }

  public int getYearId() {
    return yearId;
  }

  public int getDescriptionId() {
    return descriptionId;
  }

  public int getArtistBioId() {
    return artistBioId;
  }

  public int getArtworkImageId() {
    return artworkImageId;
  }

  public int getArtistImageId() {
    return artistImageId;
  }

  public void setArtistId(int artistId) {
    this.artistId = artistId;
  }

  public void setArtistInfoId(int artistInfoId) {
    this.artistInfoId = artistInfoId;
  }

  public void setTitleId(int titleId) {
    this.titleId = titleId;
  }

  public void setYearId(int yearId) {
    this.yearId = yearId;
  }

  public void setDescriptionId(int descriptionId) {
    this.descriptionId = descriptionId;
  }

  public void setArtistBioId(int artistBioId) {
    this.artistBioId = artistBioId;
  }

  public void setArtworkImageId(int artworkImageId) {
    this.artworkImageId = artworkImageId;
  }

  public void setArtistImageId(int artistImageId) {
    this.artistImageId = artistImageId;
  }

}
