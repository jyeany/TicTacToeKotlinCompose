{
  mode: 'development',
  resolve: {
    modules: [
      'node_modules'
    ]
  },
  plugins: [
    TeamCityErrorPlugin {}
  ],
  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          'source-map-loader'
        ],
        enforce: 'pre'
      }
    ]
  },
  entry: {
    main: [
      '/home/jyeany/CodingProjects/KotlinProjects/SimpleTicTacToe/build/js/packages/SimpleTicTacToe/kotlin/SimpleTicTacToe.js'
    ]
  },
  output: {
    path: '/home/jyeany/CodingProjects/KotlinProjects/SimpleTicTacToe/build/distributions',
    filename: [Function: filename],
    library: 'SimpleTicTacToe',
    libraryTarget: 'umd',
    globalObject: 'this'
  },
  devtool: 'eval-source-map',
  stats: {
    warningsFilter: [
      /Failed to parse source map/
    ],
    warnings: false,
    errors: false
  },
  devServer: {
    open: true,
    contentBase: [
      '/home/jyeany/CodingProjects/KotlinProjects/SimpleTicTacToe/build/processedResources/js/main'
    ]
  }
}