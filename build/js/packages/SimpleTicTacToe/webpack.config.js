let config = {
  mode: 'development',
  resolve: {
    modules: [
      "node_modules"
    ]
  },
  plugins: [],
  module: {
    rules: []
  }
};

// entry
config.entry = {
    main: ["/home/jyeany/CodingProjects/KotlinProjects/SimpleTicTacToe/build/js/packages/SimpleTicTacToe/kotlin/SimpleTicTacToe.js"]
};

config.output = {
    path: "/home/jyeany/CodingProjects/KotlinProjects/SimpleTicTacToe/build/distributions",
    filename: (chunkData) => {
        return chunkData.chunk.name === 'main'
            ? "SimpleTicTacToe.js"
            : "SimpleTicTacToe-[name].js";
    },
    library: "SimpleTicTacToe",
    libraryTarget: "umd",
    globalObject: "this"
};

// source maps
config.module.rules.push({
        test: /\.js$/,
        use: ["source-map-loader"],
        enforce: "pre"
});
config.devtool = 'eval-source-map';

config.stats = config.stats || {}
Object.assign(config.stats, config.stats, {
    warningsFilter: [/Failed to parse source map/]
})


// dev server
config.devServer = {
  "open": true,
  "contentBase": [
    "/home/jyeany/CodingProjects/KotlinProjects/SimpleTicTacToe/build/processedResources/js/main"
  ]
};

// noinspection JSUnnecessarySemicolon
;(function(config) {
    const tcErrorPlugin = require('kotlin-test-js-runner/tc-log-error-webpack');
    config.plugins.push(new tcErrorPlugin())
    config.stats = config.stats || {}
    Object.assign(config.stats, config.stats, {
        warnings: false,
        errors: false
    })
})(config);
// save evaluated config file
;(function(config) {
    const util = require('util');
    const fs = require('fs');
    const evaluatedConfig = util.inspect(config, {showHidden: false, depth: null, compact: false});
    fs.writeFile("/home/jyeany/CodingProjects/KotlinProjects/SimpleTicTacToe/build/reports/webpack/SimpleTicTacToe/webpack.config.evaluated.js", evaluatedConfig, function (err) {});
})(config);

module.exports = config
