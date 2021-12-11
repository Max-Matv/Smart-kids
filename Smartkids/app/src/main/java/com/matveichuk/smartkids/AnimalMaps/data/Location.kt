package com.matveichuk.smartkids.AnimalMaps.data

import android.graphics.Color
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions

object Location {
    fun getLocation(): MutableList<LocationData> {
        return mutableListOf(
            LocationData(
                "Слон",
                "https://images.unsplash.com/photo-1586680160345-b4e033387997?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=686&q=80",
                PolygonOptions()
                .clickable(true)
                .add(
                    LatLng(11.679334, 50.801165),
                    LatLng(-5.823405, 38.393798),
                    LatLng(-15.777051, 40.209548),
                    LatLng(-19.944052, 34.548681),
                    LatLng(-33.713825, 22.372476),
                    LatLng(3.989725, 9.234993),
                    LatLng(12.647300, -16.505931)

                )
                .fillColor(Color.GREEN)
            ),
            LocationData(
                "Тигр",
                "https://cdn.pixabay.com/photo/2019/09/07/07/42/tiger-4458133_960_720.jpg",
                PolygonOptions()
                    .clickable(true)
                    .add(
                        LatLng(24.046172, 74.542740),
                        LatLng(26.594150, 89.669658),
                        LatLng(24.297092, 100.946088),
                        LatLng(18.082405, 106.034233),
                        LatLng(12.446717, 108.303271),
                        LatLng(10.695397, 105.346646),
                        LatLng(17.033536, 98.058222),
                        LatLng(4.914285, 103.165367),
                        LatLng(2.084823, 103.841910),
                        LatLng(8.656511, 98.332916),
                        LatLng(22.310843, 90.536561),
                        LatLng(17.984072, 94.846706),
                    )
                    .fillColor(Color.RED)
            ),
            LocationData(
                "Морская свинка",
                "https://images.unsplash.com/photo-1610271772377-379a23021795?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80",
                PolygonOptions()
                    .clickable(true)
                    .add(
                        LatLng(-8.394349, -65.939571),
                        LatLng(-8.394349, -46.983313),
                        LatLng(-20.842704, -47.154090),
                        LatLng(-27.826996, -54.161012),
                        LatLng(-31.852218, -71.003243),
                        LatLng(-17.975520, -70.229572),
                        LatLng(-10.509883, -76.842849)
                    )
                    .fillColor(Color.BLUE)
            ),
            LocationData(
                "Лев",
                "https://images.unsplash.com/photo-1622562690374-edc766b13a44?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=764&q=80",
                PolygonOptions()
                    .clickable(true)
                    .add(
                        LatLng(11.679334, 50.801165),
                        LatLng(-5.823405, 38.393798),
                        LatLng(-15.777051, 40.209548),
                        LatLng(-19.944052, 34.548681),
                        LatLng(-33.713825, 22.372476),
                        LatLng(3.989725, 9.234993),
                        LatLng(12.647300, -16.505931)

                    )
                    .fillColor(Color.YELLOW)
            )
        )
    }
}