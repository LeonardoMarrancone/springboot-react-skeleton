const merge = require("webpack-merge");
const BaseConfig = require("./webpack.config.base");
module.exports = merge(BaseConfig, {
    devtool: "source-map",
    mode: "development",
    devServer: {
        port: 3030
    }
});