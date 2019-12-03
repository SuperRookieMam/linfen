<template>
  <div>
    <video ref="player"
           class="video-js vjs-default-skin vjs-big-play-centered"
           controls
           preload="auto"
           width="600"
           poster="//vjs.zencdn.net/v/oceans.png"
           height="400" />
  </div>
</template>
<script>
  import Vue from 'vue'
  import { Component, Prop, Watch } from 'vue-property-decorator'

  import Video from 'video.js'
  import 'video.js/dist/video-js.css'
  import 'videojs-contrib-hls'

  @Component({
    components: {
    }
  })
  export default class VedioPlay extends Vue {
    @Prop({default: () => ''})
    url

    @Prop({default: () => ''})
    roomNumber

    player = null

    get urlcomponet(){
      return `${this.url}${this.roomNumber}.m3u8`
    }

    mounted () {
      this.creteDisplayer()
    }

    creteDisplayer (){
      this.player = Video(this.$refs.player,
                          {
                            type: "application/x-mpegURL",
                            src: '',
                            bigPlayButton: false,
                            textTrackDisplay: false,
                            posterImage: true,
                            errorDisplay: false,
                            controlBar: true,
                            autoplay: false
                          },
                          function onPlayerReady() {
                            this.play()
                         })
    }

    destroyPlayer () {
      if (this.player) {
        this.player.dispose()
      }
    }

    beforeDestroy() {
      this.destroyPlayer()
    }


    @Watch('urlcomponet')
    wc (url) {
      this.player.src(url)
    }
  }
</script>
