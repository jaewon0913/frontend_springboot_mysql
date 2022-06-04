module.exports = {
  css: {
    sourceMap: true,
    loaderOptions: {
      scss: {
        prependData: `
          @import "~@/assets/style/_mixins.scss";
          @import "~@/assets/style/_variables.scss";
          @import "~@/assets/style/_mediaQueries.scss";
          @import "~@/assets/style/_svg.scss";
          @import "~@/assets/style/_common.scss";
        `
      }
    }
  }
}