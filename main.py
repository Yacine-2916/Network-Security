import flet as ft

def main(page: ft.Page):
    page.title = "Security Camera Monitor"

    def allow_camera_permission(e):
        page.snack_bar = ft.SnackBar(ft.Text("Permission caméra demandée..."))
        page.snack_bar.open = True
        page.update()

    page.add(
        ft.Text("App de Sécurité"),
        ft.ElevatedButton("Autoriser la caméra", on_click=allow_camera_permission)
    )

ft.app(target=main)
